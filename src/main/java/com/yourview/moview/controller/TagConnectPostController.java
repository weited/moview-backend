package com.yourview.moview.controller;

import com.yourview.moview.dto.tagConnectPost.TagConnectPostGetDto;
import com.yourview.moview.entity.Tag;
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

    @PostMapping
    public TagConnectPostGetDto create(@Valid @RequestParam("tagId") Long tagId
            , @Valid @RequestParam("postId") Long postId){
        return tagConnectPostService.createConnection(tagId, postId);
    }

    @GetMapping("/{connectionId}")
    public TagConnectPostGetDto get(@Valid @PathVariable Long connectionId){
        return tagConnectPostService.getConnection(connectionId);
    }

    @DeleteMapping("/{connectionId}")
    public void delete(@Valid @PathVariable Long connectionId){
        tagConnectPostService.deleteConnection(connectionId);
    }

    @GetMapping("/tags/{movieId}")
    public List<Tag> getTags(@Valid @PathVariable Long movieId){
        return tagConnectPostService.getHotTags(movieId);
    }


}
