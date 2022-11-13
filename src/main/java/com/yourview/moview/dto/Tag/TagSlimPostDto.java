package com.yourview.moview.dto.Tag;

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
public class TagSlimPostDto {
    @NotBlank(message = "Tag name must be provided")
    @Size(max = 20, message = "Tag name can not be more than 20 characters.")
    private String name;
}
