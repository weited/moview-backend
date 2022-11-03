package com.yourview.moview.controller;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.dto.movie.MoviePostDto;
import com.yourview.moview.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
@Validated
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<MovieGetDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public MovieGetDto getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @GetMapping("/genre/{genreId}")
    public List<MovieGetDto> getMovieByGenreId(@PathVariable Long genreId) {
        return movieService.getMovieByGenreId(genreId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieGetDto createMovie(@Valid @RequestBody MoviePostDto moviePostDto) {
        return movieService.createMovie(moviePostDto);
    }

    @PutMapping("/{movieId}")
    public MovieGetDto updateMovie(@Valid @PathVariable Long movieId,
                                   @Valid @RequestBody MoviePostDto moviePostDto) {
        return movieService.updateMovie(movieId, moviePostDto);
    }

    @DeleteMapping("/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }
}
