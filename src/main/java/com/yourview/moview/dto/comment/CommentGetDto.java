package com.yourview.moview.dto.comment;

import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.entity.Comment;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class CommentGetDto {
    private long id;
    private String text;
    private UserGetDto user;
    private Comment parentComment;
    private List<Comment> childComment;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;

}
