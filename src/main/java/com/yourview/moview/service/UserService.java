package com.yourview.moview.service;

import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.dto.user.UserPutDto;
import com.yourview.moview.dto.user.UserPostDto;
import com.yourview.moview.entity.Role;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.UserMapper;
import com.yourview.moview.entity.User;
import com.yourview.moview.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private static final String RESOURCE = "User";

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserGetDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::userToUserGetDto).collect(Collectors.toList());
    }

    public UserGetDto createUser(UserPostDto userPostDto) {
        String encodedPassword = passwordEncoder.encode(userPostDto.getPassword());
        User user = userMapper.userPostDtoToUser(userPostDto);
        user.setPassword(encodedPassword);
        log.info("Saving new user {} to database with {}", user.getEmail(), user.getPassword());
        return userMapper.userToUserGetDto(userRepository.save(user));
    }

    public void addRoleToUser(String email, String roleType) {
        User user = getByEmail(email);
        Role role = roleService.getByRoleType(roleType);
        log.info("Adding role {} to user {}", email, roleType);
        user.getRoles().add(role);
    }

    public UserGetDto get(Long userId) {
        return userMapper.userToUserGetDto(find(userId));
    }

    public UserGetDto update(UserPutDto userPutDto, Long userId) {
        User user = find(userId);

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

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, email));
    }
}

