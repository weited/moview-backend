package com.yourview.moview.service;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPatchDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.dto.Post.PostReactionDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagSlimGetDto;
import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.user.UserGetSlimDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.Tag;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private static final String POST_RESOURCE = "Post";
    private static final String MOVIE_RESOURCE = "Movie";
    private static final String USER_RESOURCE = "User";
    private final PostRepository postRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final UserService userService;
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

        Map<Boolean, List<Tag>> tagLists = postPostDto.getTagList().stream()
                .collect(Collectors.partitioningBy(s -> s.getId() != null));

        List<Tag> tagsWithoutId = tagLists.get(false);
        List<Tag> tagsWithId = tagLists.get(true);

        Set<Tag> saveTags = new HashSet<>();
        if (tagsWithoutId.size() > 0) {
            List<Tag> createdTags = tagService.saveAll(tagsWithoutId);
            saveTags.addAll(createdTags);
        }

        saveTags.addAll(tagsWithId);

        post.setContents(postPostDto.getContents());
        post.setTitle(postPostDto.getTitle());
        post.setMovie(movie);
        post.setAuthor(user);
        post.setTagList(saveTags);

        return postToPostGetDto(postRepository.save(post));
    }

    public List<PostGetDto> getAllByAuthor(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(USER_RESOURCE, id));

        return postRepository.findAllByAuthor(user).stream().map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllByMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MOVIE_RESOURCE, id));

        return postRepository.findAllByMovie(movie).stream().map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllOrderByComments() {
        List<Post> postList = postRepository.findAll();
        postList.sort((o1, o2) -> (o2.getComments().size() - o1.getComments().size()));

        return postList.stream().map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllOrderByCreatedTime() {
        return postRepository.findAllByOrderByCreatedTimeDesc().stream()
                .map(this::postToPostGetDto).collect(Collectors.toList());
    }

    public List<PostGetDto> getAllPost() {
        return postRepository.findAll().stream().map(postMapper::postToPostGetDto).collect(Collectors.toList());
    }

    public PostGetDto getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        return postMapper.postToPostGetDto(post);
    }

    public TagGetDto getPostsByTagId(Long tagId) {
        return tagService.getTagPosts(tagId);
    }

    public PostGetDto updatePost(PostPatchDto postPatchDto, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, id));

        post.setContents(postPatchDto.getContents());
        post.setTitle(postPatchDto.getTitle());
        post.setTagList(postPatchDto.getTagList());

        post = postRepository.save(post);

        return postToPostGetDto(post);
    }

    public void likesPost(Long postId, Long userId) {
        User user = userService.find(userId);
        Post post = find(postId);

        post.getLikedUsers().add(user);

        log.info("User {} liked post {}", user.getEmail(), post.getId());
        postRepository.save(post);
    }

    public void dislikePost(Long postId, Long userId) {
        User user = userService.find(userId);
        Post post = find(postId);

        Set<User> users = post.getLikedUsers();
        User dislikeUser = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("User liked post record"));

        users.remove(dislikeUser);

        log.info("User {} disliked post {}", user.getEmail(), post.getId());
        postRepository.save(post);
    }

    public PostReactionDto isUserLiked(Long postId, Optional<Long> userId) {
        User user = userId.flatMap(userRepository::findById).orElse(null);
        Post post = find(postId);

        Set<User> users = post.getLikedUsers();
        Optional<User> likedUser = userId.flatMap(aLong -> users.stream()
                .filter(u -> u.getId().equals(aLong))
                .findFirst());

        PostReactionDto postReactionDto = new PostReactionDto();
        postReactionDto.setId(post.getId());
        postReactionDto.setCurrentUser(userMapper.userToUserGetSlimDto(user));
        postReactionDto.setLike(likedUser.isPresent());
        return postReactionDto;
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public PostGetDto postToPostGetDto(Post post) {
        PostGetDto postGetDto = new PostGetDto();
        MovieGetDto movieGetDto = movieMapper.movieToMovieGetDto(post.getMovie());
        UserGetSlimDto user = userMapper.userToUserGetSlimDto(post.getAuthor());
        Set<TagSlimGetDto> tagList = tagMapper.listTagToSlimGet(post.getTagList());

        postGetDto.setId(post.getId());
        postGetDto.setContents(post.getContents());
        postGetDto.setTitle(post.getTitle());
        postGetDto.setTagList(tagList);
        postGetDto.setLikesCount(post.getLikesCount());
        postGetDto.setCreatedTime(post.getCreatedTime());
        postGetDto.setUpdatedTime(post.getUpdatedTime());
        postGetDto.setMovie(movieGetDto);
        postGetDto.setAuthor(user);
        return postGetDto;
    }

    public Post find(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, postId));
    }
}
