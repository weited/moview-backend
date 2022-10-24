package com.yourview.moview.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentPostDto {
    @NotBlank(message = "Comment text must be provided.")
    @Size(max = 800, message = "Comment text must be provided.")
    private String text;

    private long parentId;

    @NotNull(message = "Post must be provided.")
    private Long postId;

    @NotNull(message = "User must be provided.")
    private Long userId;

}
