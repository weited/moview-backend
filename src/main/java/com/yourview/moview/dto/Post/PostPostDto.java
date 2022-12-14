package com.yourview.moview.dto.Post;

import com.yourview.moview.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPostDto {
    @NotBlank
    @Size(max = 2000, message = "Contents can not be more than 2000 characters.")
    private String contents;

    @NotBlank
    @Size(max = 200, message = "Title can not be more than 200 characters.")
    private String title;

    @NotNull
    private Long movieId;

    @NotNull
    private Long authorId;

    private Set<Tag> tagList;
}
