package com.yourview.moview.dto.Post;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.user.UserGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostGetDto {
    private Long id;

    private String contents;

    private String title;

    private OffsetDateTime createdTime;

    private OffsetDateTime updateTime;

    private MovieGetDto movieGetDto;

    private UserGetDto userGetDto;
}
