package com.yourview.moview.mapper;

import com.yourview.moview.dto.comment.CommentGetDto;
import com.yourview.moview.dto.comment.CommentPostDto;
import com.yourview.moview.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    @Mapping(target = "id")
//    @Mapping(target = "User")
    @Mapping(target = "createdTime")
    @Mapping(target = "updatedTime")

    CommentGetDto commentToCommentGetDto(Comment comment);

    Comment commentPostDtoToComment(CommentPostDto commentPostDto);

}