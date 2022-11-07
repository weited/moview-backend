package com.yourview.moview.controller;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPatchDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/")
    public TagGetDto getPostsByTagId(@RequestParam(value = "tagId") Long tagId) {
        return postService.getPostsByTagId(tagId);
    }

    @GetMapping("/{postId}")
    public PostGetDto get(@Valid @PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/user/{userId}")
    public List<PostGetDto> getPostsByAuthor(@Valid @PathVariable Long authorId) {
        return postService.getAllByAuthor(authorId);
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
