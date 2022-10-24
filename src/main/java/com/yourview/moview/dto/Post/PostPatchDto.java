package com.yourview.moview.dto.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPatchDto {
    @NotBlank
    @Size(max = 2000, message = "Contents can not be more than 2000 characters.")
    private String contents;

    @NotBlank
    @Size(max = 200, message = "Title can not be more than 200 characters.")
    private String title;
}
