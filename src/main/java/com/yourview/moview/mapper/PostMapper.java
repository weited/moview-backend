package com.yourview.moview.mapper;

import com.yourview.moview.dto.Post.PostGetDto;
import com.yourview.moview.dto.Post.PostPostDto;
import com.yourview.moview.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    Post postGetDtoToPost(PostPostDto postPostDto);
    PostGetDto postToPostGetDto(Post post);
}
