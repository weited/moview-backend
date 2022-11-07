package com.yourview.moview.service;


import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.entity.TagConnectPost;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.repository.PostRepository;
import com.yourview.moview.repository.TagConnectPostRepository;
import com.yourview.moview.repository.TagRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public record TagConnectPostService(PostRepository postRepository, TagRepository tagRepository
        ,TagConnectPostRepository tagConnectPostRepository, @Lazy TagService tagService, MovieService movieService){

    private static final String POST_RESOURCE = "Post";
    private static final String Tag_RESOURCE = "Tag";
    public void createConnection(Long tagId, Long postId){
        TagConnectPost tagConnectPost = new TagConnectPost();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, postId));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException(Tag_RESOURCE, tagId));

        tagConnectPost.setPost(post);
        tagConnectPost.setTag(tag);

        tagConnectPostRepository.save(tagConnectPost);
    }

    public List<TagGetDto> getHotTagsByMovie(Long movieId){
        Movie movie = movieService.findById(movieId);

        List<Post> postList = postRepository.findAllByMovie(movie);

        List<Long[]> objList = tagConnectPostRepository.findHotTagsByPost(postList);
        List<TagGetDto> tagList = new LinkedList<>();
        objList.forEach(obj -> {
            tagList.add(tagService.tagToTagDto(tagRepository.findById(obj[0]).get()));
        });

        return tagList;
    }

    public List<TagGetDto> getHotTags(){
        List<Long[]> objList = tagConnectPostRepository.findHotTags();
        List<TagGetDto> tagList = new LinkedList<>();
        objList.forEach(obj -> {
            tagList.add(tagService.tagToTagDto(tagRepository.findById(obj[0]).get()));
        });

        return tagList;
    }


    public void deleteConnection(Long id){
        tagConnectPostRepository.deleteById(id);
    }
}
