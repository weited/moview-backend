package com.yourview.moview.controller;

import com.yourview.moview.dto.genre.GenreGetDto;
import com.yourview.moview.entity.Genre;
import com.yourview.moview.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenreList() {
        return genreService.getAllGenre();
    }

    @GetMapping("/{genreId}")
    public GenreGetDto getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }
}
