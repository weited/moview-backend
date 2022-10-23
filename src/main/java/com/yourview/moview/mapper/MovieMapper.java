package com.yourview.moview.mapper;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.movie.MoviePostDto;
import com.yourview.moview.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {
    Movie moviePostDtoToMovie(MoviePostDto moviePostDto);
    MovieGetDto movieToMovieGetDto(Movie movie);
}
