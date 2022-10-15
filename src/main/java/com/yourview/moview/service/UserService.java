package com.yourview.moview.service;


import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.dto.user.UserPutDto;
import com.yourview.moview.dto.user.UserPostDto;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.RoleMapper;
import com.yourview.moview.mapper.UserMapper;
import com.yourview.moview.entity.User;
import com.yourview.moview.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record UserService(UserRepository userRepository, UserMapper userMapper, RoleMapper roleMapper,
                          RoleService roleService) {

    private static final String RESOURCE = "User";

    public List<UserGetDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::userToUserGetDto).collect(Collectors.toList());
    }

    public UserGetDto createUser(UserPostDto userPostDto) {
        User user = userMapper.userPostDtoToUser(userPostDto);

        user.setRole(
                roleMapper.roleGetDtoToRole(roleService.getRoleById(userPostDto.getRoleId()))
        );
        return userMapper.userToUserGetDto(userRepository.save(user));
    }

    public UserGetDto get(Long userId) {
        return userMapper.userToUserGetDto(find(userId));
    }

    public UserGetDto update(UserPutDto userPutDto, Long userId) {
        User user = find(userId);
        if (userPutDto.getRoleId() != 0L) {
            user.setRole(roleMapper.roleGetDtoToRole(roleService.getRoleById(userPutDto.getRoleId())));
        }
        user.setUsername(userPutDto.getUsername());
        user.setFirstName(userPutDto.getFirstName());
        user.setLastName(userPutDto.getLastName());
        user.setPassword(userPutDto.getPassword());
        user.setEmail(userPutDto.getEmail());
        user.setProfileImgUrl(userPutDto.getProfileImgUrl());
        return userMapper.userToUserGetDto(userRepository.save(user));
    }

    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    public User find(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, userId));
    }
}

