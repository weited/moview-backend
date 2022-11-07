package com.yourview.moview.service;

import com.yourview.moview.entity.*;
import com.yourview.moview.exception.ResourceNotFoundException;

import com.yourview.moview.repository.*;
import org.springframework.stereotype.Service;

@Service
public record TagConnectUserService(UserRepository userRepository, TagRepository tagRepository
        , TagConnectUserRepository tagConnectUserRepository){

    private static final String User_RESOURCE = "User";
    private static final String Tag_RESOURCE = "Tag";

    public void createConnection(Long tagId, Long userId){
        TagConnectUser tagConnectUser = new TagConnectUser();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(User_RESOURCE, userId));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException(Tag_RESOURCE, tagId));

        tagConnectUser.setUser(user);
        tagConnectUser.setTag(tag);

        tagConnectUserRepository.save(tagConnectUser);
    }

    public void deleteConnection(Long id){
        tagConnectUserRepository.deleteById(id);
    }

}
