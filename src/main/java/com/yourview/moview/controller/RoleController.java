package com.yourview.moview.controller;

import com.yourview.moview.dto.role.RoleGetDto;
import com.yourview.moview.entity.Role;
import com.yourview.moview.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<Role> getAllRoleList() {

        return roleService.getAllRole();
    }

    @GetMapping("/{roleId}")
    public RoleGetDto getRoleById(@PathVariable Long roleId) {

        return roleService.getRoleById(roleId);
    }
}