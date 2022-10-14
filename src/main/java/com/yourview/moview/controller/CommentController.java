package com.yourview.moview.controller;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPatchDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentGetDto> getAllComments() {
        return commentService.getAllComments();
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

    @PatchMapping("/{commentId}")
    public CommentGetDto update(@PathVariable Long commentId, @RequestBody CommentPatchDto commentPatchDto) {
        return commentService.updateComment(commentId, commentPatchDto);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
