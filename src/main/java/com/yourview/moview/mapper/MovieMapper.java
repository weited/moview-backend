package com.yourview.moview.mapper;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.movie.MoviePostDto;
import com.yourview.moview.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "createdTime", ignore = true)
    @Mapping(target = "updatedTime", ignore = true)
    Movie moviePostDtoToMovie(MoviePostDto moviePostDto);

    MovieGetDto movieToMovieGetDto(Movie movie);
}
