package com.yourview.moview.service;

import com.yourview.moview.dto.genre.GenreGetDto;
import com.yourview.moview.entity.Genre;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.GenreMapper;
import com.yourview.moview.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
    private static final String RESOURCE = "Genre";

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public GenreGetDto getGenreById(Long genreId) {
        return genreMapper.genreToGenreGetDto(genreRepository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE, genreId)));
    }
}
