package com.yourview.moview.dto.comment;

import com.yourview.moview.dto.user.UserGetSlimDto;
import com.yourview.moview.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetDto {
    private long id;
    private String text;
    private UserGetSlimDto user;
    private Comment parentComment;
    private List<Comment> childComment;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
