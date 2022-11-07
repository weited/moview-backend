package com.yourview.moview.controller;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.service.TagConnectPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tagconnectionpost")
public class TagConnectPostController {
    private final TagConnectPostService tagConnectPostService;

    @GetMapping("/tags/{movieId}")
    public List<TagGetDto> getHotTagsByMovie(@Valid @PathVariable Long movieId){
        return tagConnectPostService.getHotTagsByMovie(movieId);
    }

    @GetMapping("/tags")
    public List<TagGetDto> getHotTags(){
        return tagConnectPostService.getHotTags();
    }

    @DeleteMapping("/{connectionId}")
    public void delete(@Valid @PathVariable Long connectionId){
        tagConnectPostService.deleteConnection(connectionId);
    }

}
