package com.yourview.moview.service;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.movie.MoviePostDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.GenreMapper;
import com.yourview.moview.mapper.MovieMapper;
import com.yourview.moview.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record MovieService(MovieRepository movieRepository, MovieMapper movieMapper, GenreMapper genreMapper,
                           GenreService genreService) {
    private static final String RESOURCE = "Movie";

    public List<MovieGetDto> getAllMovies() {
        return movieRepository.findAll().stream().map(movieMapper::movieToMovieGetDto).collect(Collectors.toList());
    }

    public MovieGetDto getMovieById(Long movieId) {
        return movieMapper.movieToMovieGetDto(findById(movieId));
    }

    public MovieGetDto createMovie(MoviePostDto moviePostDto) {
        Movie movie = movieMapper.moviePostDtoToMovie(moviePostDto);

        movie.setGenre(
                genreMapper.genreGetDtoToGenre(genreService.getGenreById(moviePostDto.getGenreId()))
        );
        return movieMapper.movieToMovieGetDto(movieRepository.save(movie));
    }

    public MovieGetDto updateMovie(Long movieId, MoviePostDto moviePostDto) {
        Movie movie = findById(movieId);

        if (moviePostDto.getGenreId() != 0L) {
            movie.setGenre(genreMapper.genreGetDtoToGenre(genreService.getGenreById(moviePostDto.getGenreId())));
        }
        movie.setName(moviePostDto.getName());
        movie.setRating(moviePostDto.getRating());
        movie.setYear(moviePostDto.getYear());
        movie.setDirector(moviePostDto.getDirector());
        movie.setActor(moviePostDto.getActor());
        movie.setDescription(moviePostDto.getDescription());
        movie.setPosterImgUrl(moviePostDto.getPosterImgUrl());

        return movieMapper.movieToMovieGetDto(movieRepository.save(movie));
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    public Movie findById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, movieId));
    }
}
