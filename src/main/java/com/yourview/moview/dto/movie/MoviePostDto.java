package com.yourview.moview.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePostDto {
    @NotBlank(message = "Movie name must be provided.")
    @Size(max = 255, message = "Movie name can not be more than 255 characters.")
    private String name;

    @NotNull(message = "Genre must be provided.")
    private Long genreId;

    @NotBlank
    @Min(value = 1900, message = "Year must be greater than or equal to 1900.")
    @Max(value = 2099, message = "Year must be less than or equal to 2099.")
    private String year;

    @NotBlank(message = "Director must not be blank.")
    @Size(max = 128, message = "Director name can not be more than 128 characters.")
    private String director;

    @NotBlank(message = "Actor must not be blank.")
    private String actor;

    @NotBlank
    @Size(max = 1000, message = "Description can not be more than 1000 characters.")
    private String description;

    @NotEmpty
    private String posterImgUrl;
}
