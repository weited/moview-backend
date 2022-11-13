package com.yourview.moview.mapper;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagPostDto;
import com.yourview.moview.dto.Tag.TagSlimGetDto;
import com.yourview.moview.dto.Tag.TagSlimPostDto;
import com.yourview.moview.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    TagGetDto tagToTagGetDto(Tag tag);
    TagSlimGetDto tagToTagSlimGetDto(Tag tag);
    Set<TagSlimGetDto> listTagToSlimGet(Set<Tag> tags);
    Set<Tag> listTagPostToTag(Set<TagPostDto> tags);
    List<Tag> listTagSlimPostToTag(List<TagSlimPostDto> tags);
}
