package com.yourview.moview.service;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPatchDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.User;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.MovieMapper;
import com.yourview.moview.mapper.UserMapper;
import com.yourview.moview.repository.MovieRepository;
import com.yourview.moview.repository.PostRepository;
import com.yourview.moview.repository.TagRepository;
import com.yourview.moview.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public record PostService(PostRepository postRepository, TagRepository tagRepository
        , TagService tagService, MovieRepository movieRepository, UserRepository userRepository
        , MovieMapper movieMapper, UserMapper userMapper) {

    private static final String POST_RESOURCE = "Post";
    private static final String MOVIE_RESOURCE = "Movie";
    private static final String USER_RESOURCE = "User";

    public PostGetDto createPost(PostPostDto postPostDto){
        Post post = new Post();

        Movie movie = movieRepository.findById(postPostDto.getMovieId())
                .orElseThrow(() -> new ResourceNotFoundException(MOVIE_RESOURCE, postPostDto.getMovieId()));

        User user = userRepository.findById(postPostDto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(USER_RESOURCE, postPostDto.getAuthorId()));

        post.setContents(postPostDto.getContents());
        post.setTitle(postPostDto.getTitle());
        post.setMovie(movie);
        post.setUser(user);
        post = postRepository.save(post);

        return postToPostGetDto(post);
    }

    public PostGetDto getPost(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        return postToPostGetDto(post);
    }

    public PostGetDto updatePost(PostPatchDto postPatchDto, Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        post.setContents(postPatchDto.getContents());
        post.setTitle(postPatchDto.getTitle());

        post = postRepository.save(post);

        return postToPostGetDto(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public PostGetDto postToPostGetDto(Post post){
        PostGetDto postGetDto = new PostGetDto();
        MovieGetDto movieGetDto = movieMapper.movieToMovieGetDto(post.getMovie());
        UserGetDto userGetDto = userMapper.userToUserGetDto(post.getUser());

        postGetDto.setId(post.getId());
        postGetDto.setContents(post.getContents());
        postGetDto.setTitle(post.getTitle());
        postGetDto.setCreatedTime(post.getCreatedTime());
        postGetDto.setUpdateTime(post.getUpdatedTime());
        postGetDto.setMovieGetDto(movieGetDto);
        postGetDto.setUserGetDto(userGetDto);
        return postGetDto;
    }
}
