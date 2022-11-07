package com.yourview.moview.repository;

import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMovie(Movie movie);
    List<Post> findAllByAuthor(User user);
    List<Post> findAllByOrderByCreatedTimeDesc();
    List<Post> findPostByTagListId(Long tagId);
}
