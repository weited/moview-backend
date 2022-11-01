package com.yourview.moview.mapper;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagSlimDto;
import com.yourview.moview.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    TagGetDto tagToTagGetDto(Tag tag);
    TagSlimDto tagToTagSlimDto(Tag tag);
    List<TagSlimDto> tagListToSlimList(List<Tag> tags);
}
