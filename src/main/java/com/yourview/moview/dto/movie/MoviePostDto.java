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

    @NotBlank(message = "Release year must be provided.")
    @Min(value = 1900, message = "Year must be greater than or equal to 1900.")
    @Max(value = 2099, message = "Year must be less than or equal to 2099.")
    private String year;

    @NotBlank(message = "Rating must be provided.")
    @Min(value = 1, message = "Rating must be greater than or equal to 1.")
    @Max(value = 10, message = "Rating must be less than or equal to 10.")
    @Size(max = 3, message = "Movie rating can not be more than 3 characters.")
    private String rating;

    @NotBlank(message = "Director must be provided.")
    @Size(max = 128, message = "Director name can not be more than 128 characters.")
    private String director;

    @NotBlank(message = "Actor must be provided.")
    private String actor;

    @NotBlank(message = "Description must be provided.")
    @Size(max = 1000, message = "Description can not be more than 1000 characters.")
    private String description;

    private String posterImgUrl;
}
