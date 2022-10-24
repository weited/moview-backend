package com.yourview.moview.repository;

import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMovie(Movie movie);
}
