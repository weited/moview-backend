package com.yourview.moview.controller;

import com.yourview.moview.auth.MoviewAuthenticationToken;
import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPatchDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.dto.Post.PostReactionDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("posts")
@CrossOrigin
public class PostController {
    private final PostService postService;

    @PostMapping
    public PostGetDto create(@Valid @RequestBody PostPostDto postPostDto) {
        return postService.createPost(postPostDto);
    }

    @GetMapping
    public List<PostGetDto> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping("/tag/{tagId}")
    @Operation(summary = "Get all review posts by tag id")
    public TagGetDto getPostsByTagId(@Valid @PathVariable Long tagId) {
        return postService.getPostsByTagId(tagId);
    }

    @GetMapping("/{postId}")
    public PostGetDto get(@Valid @PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @PostMapping("/{postId}/like")
    @Operation(summary = "Like a post by post id")
    @ResponseStatus(HttpStatus.CREATED)
    public void likesPost(@Valid @PathVariable Long postId, Authentication authentication) {
        MoviewAuthenticationToken authDetails = (MoviewAuthenticationToken) authentication;
        Long userId = authDetails.getUserId();

        postService.likesPost(postId, userId);
    }

    @DeleteMapping("/{postId}/dislike")
    @Operation(summary = "Dislike a post by post id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dislikePost(@Valid @PathVariable Long postId, Authentication authentication) {
        MoviewAuthenticationToken authDetails = (MoviewAuthenticationToken) authentication;
        Long userId = authDetails.getUserId();

        postService.dislikePost(postId, userId);
    }

    @GetMapping("/{postId}/reactions")
    @Operation(summary = "Check post reaction of current logged user")
    public PostReactionDto postReactions(@Valid @PathVariable Long postId, Authentication authentication) {
        MoviewAuthenticationToken authDetails = (MoviewAuthenticationToken) authentication;

        Optional<Long> userId;
        if (authDetails != null) {
            userId = Optional.ofNullable(authDetails.getUserId());
        } else {
            userId = Optional.empty();
        }

        return postService.isUserLiked(postId, userId);
    }

    @GetMapping("/user/{authorId}")
    public List<PostGetDto> getPostsByAuthor(@Valid @PathVariable Long authorId) {
        return postService.getAllByAuthor(authorId);
    }

    @GetMapping("/movie/{movieId}")
    public List<PostGetDto> getPostsByMovie(@Valid @PathVariable Long movieId) {
        return postService.getAllByMovie(movieId);
    }

    @GetMapping("/createdtime")
    public List<PostGetDto> orderByCreatedTime() {
        return postService.getAllOrderByCreatedTime();
    }

    @GetMapping("/comments")
    public List<PostGetDto> orderByComments() {
        return postService.getAllOrderByComments();
    }

    @PatchMapping("/{postId}")
    public PostGetDto update(@Valid @RequestBody PostPatchDto postPatchDto, @Valid @PathVariable Long postId) {
        return postService.updatePost(postPatchDto, postId);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @PathVariable Long postId) {
        postService.deletePost(postId);
    }

}
