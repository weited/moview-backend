package com.yourview.moview.service;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPutDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.entity.Comment;
import com.yourview.moview.entity.Post;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.CommentMapper;
import com.yourview.moview.repository.CommentRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public record CommentService(CommentRepository commentRepository, CommentMapper commentMapper,
                             UserService userService, PostService postService) {
    private static final String RESOURCE = "Comment";

    public CommentGetDto createNewComment(CommentPostDto commentPostDto) {
        Comment comment = commentMapper.commentPostDtoToComment(commentPostDto);
        comment.setUser(userService.find(commentPostDto.getUserId()));
        if(commentPostDto.getParentId() != 0L){
            comment.setParentComment(find(commentPostDto.getParentId()));
        }
        comment.setPost(postService.find(commentPostDto.getPostId()));
        return commentMapper.commentToCommentGetDto(commentRepository.save(comment));
    }

    public CommentGetDto getCommentByCommentId(Long commentId) {
        return commentMapper.commentToCommentGetDto(find(commentId));

    }

    public List<CommentGetDto> getCommentByPostId(Long postId) {
        Post post = new Post();
        post.setId(postId);
        Comment filter = new Comment();
        filter.setPost(post);
        List<Comment> allResults = commentRepository.findAll(Example.of(filter));
        List<CommentGetDto> allParentComments = allResults.stream().filter(comment -> Objects.isNull(comment.getParentComment())).sorted(Comparator.comparingLong(Comment::getId)).map(commentMapper::commentToCommentGetDto).toList();
        List<Comment> allChildComments = allResults.stream().filter(comment -> !Objects.isNull(comment.getParentComment())).toList();
        allParentComments.forEach(parent -> {
            parent.setChildComment( allChildComments.stream().filter(child -> Objects.equals(child.getParentComment().getId(), parent.getId())).map((childComments) -> {
                Comment comment = new Comment();
                comment.setId(childComments.getId());
                comment.setUpdatedTime(childComments.getUpdatedTime());
                comment.setCreatedTime(childComments.getCreatedTime());
                comment.setText(childComments.getText());
                comment.setUser(childComments.getUser());
                return comment;
            }).toList());
        });
        return allParentComments;
    }

    public CommentGetDto updateComment(Long commentId, CommentPutDto commentPutDto) {
        Comment comment = find(commentId);
        comment.setText(commentPutDto.getText());
        return commentMapper.commentToCommentGetDto(commentRepository.save(comment));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public Comment find(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, commentId));
    }


}
