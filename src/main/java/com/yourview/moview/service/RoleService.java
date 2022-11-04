package com.yourview.moview.service;

import com.yourview.moview.dto.role.RoleGetDto;
import com.yourview.moview.exception.ResourceNotFoundException;
import com.yourview.moview.mapper.RoleMapper;
import com.yourview.moview.entity.Role;
import com.yourview.moview.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private static final String RESOURCE = "Role";

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public RoleGetDto getRoleById(Long roleId) {
        return roleMapper.roleToRoleGetDto(roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE, roleId)));
    }

    public Role getByRoleType(String roleType) {
        return roleRepository.findByRoleType(roleType).orElseThrow(() -> new ResourceNotFoundException(RESOURCE, roleType));
    }
}