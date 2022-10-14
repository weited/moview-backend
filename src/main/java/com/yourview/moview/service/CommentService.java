package com.yourview.moview.service;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPatchDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.entity.Comment;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.CommentMapper;
import com.yourview.moview.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public record CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
    private static final String RESOURCE = "Comment";

    public List<CommentGetDto> getAllComments() {
        return commentRepository.findAll().stream().map(commentMapper::commentToCommentGetDto).collect(Collectors.toList());
    }

    public CommentGetDto createNewComment(CommentPostDto commentPostDto) {
        Comment comment = commentMapper.commentPostDtoToComment(commentPostDto);
//        comment.setUser(userService.find(commentPostDto.getUserId());
        return commentMapper.commentToCommentGetDto(commentRepository.save(comment));
    }

    public CommentGetDto getCommentByCommentId(Long commentId) {

        return commentMapper.commentToCommentGetDto(find(commentId));

    }

    public CommentGetDto updateComment(Long commentId, CommentPatchDto commentPatchDto) {
        Comment comment = find(commentId);
        comment.setText(commentPatchDto.getText());
        return commentMapper.commentToCommentGetDto(commentRepository.save(comment));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment find(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, commentId));
    }


}
