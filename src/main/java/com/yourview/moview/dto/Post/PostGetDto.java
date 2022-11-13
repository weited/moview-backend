package com.yourview.moview.dto.Post;

import com.yourview.moview.dto.Tag.TagSlimGetDto;
import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.user.UserGetSlimDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostGetDto {
    private Long id;
    private String contents;
    private String title;
    private Set<TagSlimGetDto> tagList;
    private MovieGetDto movie;
    private UserGetSlimDto author;
    private OffsetDateTime createdTime;
    private OffsetDateTime updatedTime;
}
