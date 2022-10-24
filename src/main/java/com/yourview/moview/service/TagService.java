package com.yourview.moview.service;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagPostDto;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public record TagService(TagRepository tagRepository) {
    private static final String RESOURCE = "Tag";
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

    public TagGetDto getTag(Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, id));

        return tagToTagDto(tag);
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

    public TagGetDto tagToTagDto(Tag tag){
        TagGetDto tagGetDto = new TagGetDto();
        tagGetDto.setId(tag.getId());
        tagGetDto.setTagName(tag.getName());

        return tagGetDto;
    }

}
