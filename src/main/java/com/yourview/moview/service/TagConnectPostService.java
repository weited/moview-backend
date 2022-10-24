package com.yourview.moview.service;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.tagConnectPost.TagConnectPostGetDto;
import com.yourview.moview.entity.Movie;
import com.yourview.moview.entity.Post;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.entity.TagConnectPost;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.repository.PostRepository;
import com.yourview.moview.repository.TagConnectPostRepository;
import com.yourview.moview.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Service
public record TagConnectPostService(PostRepository postRepository, TagRepository tagRepository
        , TagConnectPostRepository tagConnectPostRepository, TagService tagService
        , PostService postService, MovieService movieService){

    private static final String PERSISTENCE_NAME = "openJPA";
    private static final String POST_RESOURCE = "Post";
    private static final String Tag_RESOURCE = "Tag";
    private static final String TagConnectPost_RESOURCE = "TagConnectPost";
    public TagConnectPostGetDto createConnection(Long tagId, Long postId){
        TagConnectPost tagConnectPost = new TagConnectPost();
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_RESOURCE, postId));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException(Tag_RESOURCE, tagId));

        tagConnectPost.setPost(post);
        tagConnectPost.setTag(tag);

        tagConnectPostRepository.save(tagConnectPost);

        return tagConnectPostToTagConnectPostGetDto(tagConnectPost);
    }

    public TagConnectPostGetDto getConnection(Long id){
        TagConnectPost tagConnectPost = tagConnectPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TagConnectPost_RESOURCE, id));

        return tagConnectPostToTagConnectPostGetDto(tagConnectPost);
    }

    public List<Tag> getHotTags(Long movieId){
        Movie movie = movieService.findById(movieId);

        List<Post> postList = postRepository.findAllByMovie(movie);

        List<Long[]> objList = tagConnectPostRepository.findHotTags(postList);
        List<Tag> tagList = new LinkedList<>();
        objList.stream().forEach(obj -> {
            tagList.add(tagRepository.findById(obj[0]).get());
        });

        return tagList;
    }


    public void deleteConnection(Long id){
        tagConnectPostRepository.deleteById(id);
    }

    public TagConnectPostGetDto tagConnectPostToTagConnectPostGetDto(TagConnectPost tagConnectPost){
        PostGetDto postGetDto = postService.postToPostGetDto(tagConnectPost.getPost());
        TagGetDto tagGetDto = tagService.tagToTagDto(tagConnectPost.getTag());

        TagConnectPostGetDto tagConnectPostGetDto = new TagConnectPostGetDto();
        tagConnectPostGetDto.setTagGetDto(tagGetDto);
        tagConnectPostGetDto.setPostGetDto(postGetDto);
        tagConnectPostGetDto.setId(tagConnectPost.getId());
        tagConnectPostGetDto.setCreatedTime(tagConnectPost.getCreatedTime());
        tagConnectPostGetDto.setUpdatedTime(tagConnectPost.getUpdatedTime());

        return tagConnectPostGetDto;
    }

}
