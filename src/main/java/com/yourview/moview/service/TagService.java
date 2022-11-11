package com.yourview.moview.service;

import com.yourview.moview.dto.Tag.TagGetDto;
import com.yourview.moview.dto.Tag.TagPostDto;
import com.yourview.moview.dto.Tag.TagSlimDto;
import com.yourview.moview.entity.Tag;
import com.yourview.moview.entity.User;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.TagMapper;
import com.yourview.moview.repository.TagConnectUserRepository;
import com.yourview.moview.repository.TagRepository;
import com.yourview.moview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private static final String TAG_RESOURCE = "Tag";
    private static final String USER_RESOURCE = "User";

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    private final UserRepository userRepository;

    private final TagConnectPostService tagConnectPostService;

    private final TagConnectUserService tagConnectUserService;

    private final TagConnectUserRepository tagConnectUserRepository;

    @Transactional
    public TagGetDto createTag(TagPostDto tagPostDto){
        if(tagRepository.findByName(tagPostDto.getTagName()).isEmpty()){
            Tag tag = new Tag();
            tag.setName(tagPostDto.getTagName());

            tag = tagRepository.save(tag);

            tagConnectPostService.createConnection(tag.getId(), tagPostDto.getPostId());
            tagConnectUserService.createConnection(tag.getId(), tagPostDto.getUserId());
            return tagToTagDto(tag);
       }
        else {
            Tag tag = tagRepository.findByName(tagPostDto.getTagName()).get();

            tagConnectPostService.createConnection(tag.getId(), tagPostDto.getPostId());
            tagConnectUserService.createConnection(tag.getId(), tagPostDto.getUserId());
            return tagToTagDto(tag);
        }
    }

    public List<TagSlimDto> getAllTags() {
        return tagRepository.findAll().stream().map(tagMapper::tagToTagSlimDto).collect(Collectors.toList());
    }

    @Transactional
    public List<TagGetDto> createTags(List<TagPostDto> tagPostDtoList){
        List<TagGetDto> res = new LinkedList<>();
        tagPostDtoList.forEach(tagPostDto -> res.add(createTag(tagPostDto)));
        return res;
    }

    public TagGetDto getTag(Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TAG_RESOURCE, id));

        return tagToTagDto(tag);
    }

    public List<TagGetDto> getTagsByUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(USER_RESOURCE, id));
        List<TagGetDto> res = new LinkedList<>();
        tagConnectUserRepository.findAllByUser(user).stream().map(x -> x.getTag().getId()).distinct()
                .toList().forEach(x -> res.add(tagToTagDto(tagRepository.findById(x).get())));

        return res;
    }

    @Transactional
    public TagGetDto getTagPosts(Long tagId) {
        Tag tag = findById(tagId);
        return tagMapper.tagToTagGetDto(tag);
    }

    public TagGetDto updateTag(TagPostDto tagPostDto, Long id){
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TAG_RESOURCE, id));
        tag.setName(tagPostDto.getTagName());

        tag =tagRepository.save(tag);
        return tagToTagDto(tag);
    }


    public void deleteTag(Long id){
        tagRepository.deleteById(id);
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TAG_RESOURCE, id));
    }

    public TagGetDto tagToTagDto(Tag tag){
        TagGetDto tagGetDto = new TagGetDto();
        tagGetDto.setId(tag.getId());
        tagGetDto.setName(tag.getName());

        return tagGetDto;
    }
}
