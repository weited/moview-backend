package com.yourview.moview.repository;

import com.yourview.moview.dto.movie.MovieGetDto;
import com.yourview.moview.entity.Genre;
import com.yourview.moview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<MovieGetDto> findMoviesByGenreId(Long genreId);
}
