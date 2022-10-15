package com.yourview.moview.service;

import com.yourview.moview.dto.role.RoleGetDto;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.RoleMapper;
import com.yourview.moview.entity.Role;
import com.yourview.moview.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
    private static final String RESOURCE = "Role";


    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public RoleGetDto getRoleById(Long roleId) {
        return roleMapper.roleToRoleGetDto(roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE, roleId)));
    }
}