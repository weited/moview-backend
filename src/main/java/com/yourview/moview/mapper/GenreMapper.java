package com.yourview.moview.mapper;

import com.yourview.moview.dto.genre.GenreGetDto;
import com.yourview.moview.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper {
    Genre genreGetDtoToGenre(GenreGetDto genreGetDto);
    GenreGetDto genreToGenreGetDto(Genre genre);
}
