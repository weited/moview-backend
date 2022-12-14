package com.yourview.moview.controller;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPutDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/post/{postId}")
    public List<CommentGetDto> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentByPostId(postId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentGetDto createComment(@Valid @RequestBody CommentPostDto commentPostDto) {
        return commentService.createNewComment(commentPostDto);
    }

    @GetMapping("/{commentId}")
    public CommentGetDto get(@PathVariable Long commentId) {
        return commentService.getCommentByCommentId(commentId);
    }

    @PutMapping("/{commentId}")
    public CommentGetDto update(@PathVariable Long commentId, @RequestBody CommentPutDto commentPutDto) {
        return commentService.updateComment(commentId, commentPutDto);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
