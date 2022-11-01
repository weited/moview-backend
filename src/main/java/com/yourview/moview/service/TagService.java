package com.yourview.moview.service;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagPostDto;
import com.yourview.moview.dto.Tag.TagSlimDto;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.TagMapper;
import com.yourview.moview.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TagService {
    private static final String RESOURCE = "Tag";

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagGetDto createTag(TagPostDto tagPostDto){
        if(tagRepository.findByName(tagPostDto.getTagName()).isEmpty()){
            Tag tag = new Tag();
            tag.setName(tagPostDto.getTagName());

            tag = tagRepository.save(tag);

            return tagToTagDto(tag);
        }
        else {
            Tag tag = tagRepository.findByName(tagPostDto.getTagName()).get();
            return tagToTagDto(tag);
        }
    }

    public TagSlimDto getTag(Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, id));

        return tagMapper.tagToTagSlimDto(tag);
    }

    @Transactional
    public TagGetDto getTagPosts(Long tagId) {
        Tag tag = findById(tagId);
        return tagMapper.tagToTagGetDto(tag);
    }

    public TagGetDto updateTag(TagPostDto tagPostDto, Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, id));
        tag.setName(tagPostDto.getTagName());

        tag =tagRepository.save(tag);

        return tagToTagDto(tag);
    }


    public void deleteTag(Long id){
        tagRepository.deleteById(id);
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, id));
    }

    public TagGetDto tagToTagDto(Tag tag){
        TagGetDto tagGetDto = new TagGetDto();
        tagGetDto.setId(tag.getId());
        tagGetDto.setName(tag.getName());

        return tagGetDto;
    }

}
