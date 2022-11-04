package com.yourview.moview.controller;

import com.yourview.moview.dto.user.UserAddRoleDto;
import com.yourview.moview.dto.user.UserGetDto;
import com.yourview.moview.dto.user.UserPutDto;
import com.yourview.moview.dto.user.UserPostDto;
import com.yourview.moview.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "Create new user")
    public ResponseEntity<UserGetDto> createUser(@Valid @RequestBody UserPostDto userPostDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userPostDto));
    }

    @PostMapping("/add-role")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserAddRoleDto userAddRole) {
        userService.addRoleToUser(userAddRole.getEmail(), userAddRole.getRoleType());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<UserGetDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserGetDto get(@PathVariable Long userId) {
        return userService.get(userId);
    }

    @PutMapping("/{userId}")
    public UserGetDto update(@Valid @RequestBody UserPutDto userPutDto, @PathVariable Long userId) {
        return userService.update(userPutDto, userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
