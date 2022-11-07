package com.yourview.moview.service;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPatchDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagSlimDto;
import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.user.UserGetSlimDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.User;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.PostMapper;
import com.yourview.moview.mapper.TagMapper;
import com.yourview.moview.mapper.UserMapper;
import com.yourview.moview.mapper.MovieMapper;
import com.yourview.moview.repository.MovieRepository;
import com.yourview.moview.repository.PostRepository;
import com.yourview.moview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService {
    private static final String POST_RESOURCE = "Post";
    private static final String MOVIE_RESOURCE = "Movie";
    private static final String USER_RESOURCE = "User";
    private final PostRepository postRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final TagService tagService;
    private final PostMapper postMapper;
    private final MovieMapper movieMapper;
    private final UserMapper userMapper;
    private final TagMapper tagMapper;

    public PostGetDto createPost(PostPostDto postPostDto) {
        Post post = new Post();

        Movie movie = movieRepository.findById(postPostDto.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException(MOVIE_RESOURCE, postPostDto.getMovieId()));

        User user = userRepository.findById(postPostDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(USER_RESOURCE, postPostDto.getAuthorId()));

        post.setContents(postPostDto.getContents());
        post.setTitle(postPostDto.getTitle());
        post.setMovie(movie);
        post.setAuthor(user);
        post = postRepository.save(post);

        return postToPostGetDto(post);
    }

    public List<PostGetDto> getAllByAuthor(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_RESOURCE, id));

        return postRepository.findAllByAuthor(user).stream().map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllOrderByComments(){
        List<Post> postList = postRepository.findAll();
        postList.sort((o1,o2)-> (o2.getComments().size() - o1.getComments().size()));

        return postList.stream().map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllOrderByCreatedTime(){
        return postRepository.findAllByOrderByCreatedTimeDesc().stream()
                .map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllPost() {
        return postRepository.findAll().stream().map(postMapper::postToPostGetDto).collect(Collectors.toList());
    }

    public PostGetDto getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        return postToPostGetDto(post);
    }

    public TagGetDto getPostsByTagId(Long tagId) {
        return tagService.getTagPosts(tagId);
    }

    public PostGetDto updatePost(PostPatchDto postPatchDto, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        post.setContents(postPatchDto.getContents());
        post.setTitle(postPatchDto.getTitle());

        post = postRepository.save(post);

        return postToPostGetDto(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public PostGetDto postToPostGetDto(Post post) {
        PostGetDto postGetDto = new PostGetDto();
        MovieGetDto movieGetDto = movieMapper.movieToMovieGetDto(post.getMovie());
        UserGetSlimDto user = userMapper.userToUserGetSlimDto(post.getAuthor());
        List<TagSlimDto> tagList = tagMapper.tagListToSlimList(post.getTagList());

        postGetDto.setId(post.getId());
        postGetDto.setContents(post.getContents());
        postGetDto.setTitle(post.getTitle());
        postGetDto.setTagList(tagList);
        postGetDto.setCreatedTime(post.getCreatedTime());
        postGetDto.setUpdatedTime(post.getUpdatedTime());
        postGetDto.setMovie(movieGetDto);
        postGetDto.setAuthor(user);
        return postGetDto;
    }
}
