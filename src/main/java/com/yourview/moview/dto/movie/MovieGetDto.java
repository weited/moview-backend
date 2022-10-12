package com.yourview.moview.dto.movie;

import com.yourview.moview.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MovieGetDto {
    private long id;
    private String name;
    private Genre genre;
    private String year;
    private String director;
    private String actor;
    private String description;
    private String posterImgUrl;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
