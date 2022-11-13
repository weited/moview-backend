package com.yourview.moview.controller;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagPostDto;
import com.yourview.moview.dto.Tag.TagSlimGetDto;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tags")
public class TagController {
    private final TagService tagService;

    @GetMapping
    @Operation(summary = "Get all tags")
    public List<TagSlimGetDto> getAll() {
        return tagService.getAllTags();
    }

    @PostMapping("/create-tags")
    @Operation(summary = "Create multiple tags")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Tag> saveAll(@RequestBody List<Tag> tagList) {
        return tagService.saveAll(tagList);
    }

    @PostMapping
    public TagGetDto create(@Valid @RequestBody TagPostDto tagPostDto) {
        return tagService.createTag(tagPostDto);
    }

    @PostMapping("/createTags")
    public List<TagGetDto> createTags(@Valid @RequestBody List<TagPostDto> tagPostDtoList) {
        return tagService.createTags(tagPostDtoList);
    }

    @GetMapping("/{tagId}")
    public TagGetDto get(@PathVariable Long tagId) {
        return tagService.getTag(tagId);
    }

    @GetMapping("/user/{userId}")
    public List<TagGetDto> getTagsByUser(@PathVariable Long userId) {
        return tagService.getTagsByUser(userId);
    }

    @PutMapping("/{tagId}")
    public TagGetDto update(@Valid @RequestBody TagPostDto tagPostDto, @PathVariable Long tagId) {
        return tagService.updateTag(tagPostDto, tagId);
    }

    @DeleteMapping("/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long tagId) {
        tagService.deleteTag(tagId);
    }
}
