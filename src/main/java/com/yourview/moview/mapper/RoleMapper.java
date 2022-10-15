package com.yourview.moview.mapper;


import com.yourview.moview.dto.role.RoleGetDto;
import com.yourview.moview.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {
    Role roleGetDtoToRole(RoleGetDto roleGetDto);
    RoleGetDto roleToRoleGetDto(Role role);
}