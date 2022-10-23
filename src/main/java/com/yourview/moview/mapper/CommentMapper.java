package com.yourview.moview.mapper;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentGetDto commentToCommentGetDto(Comment comment);

    Comment commentPostDtoToComment(CommentPostDto commentPostDto);

}