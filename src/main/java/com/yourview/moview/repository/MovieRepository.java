package com.yourview.moview.repository;

import com.yourview.moview.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//    List<Movie> findMoviesByGenreIdIs(Long movieId);
}
