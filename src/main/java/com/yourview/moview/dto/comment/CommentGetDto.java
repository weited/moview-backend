package com.yourview.moview.dto.comment;

import com.yourview.moview.dto.post.PostGetDto;
import com.yourview.moview.dto.user.UserGetDto;
import lombok.*;

import java.time.OffsetDateTime;

@Data
public class CommentGetDto {
    private long id;
    private String text;
    private UserGetDto user;
    private PostGetDto post;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
