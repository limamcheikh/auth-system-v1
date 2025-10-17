package com.auth.app.services;


import java.util.List;


import com.auth.app.dto.RoleDto;
import com.auth.app.models.Role;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(String id);
    RoleDto getRoleByName(String name);
    List<RoleDto> getAllRoles();
    RoleDto updateRole(String id, RoleDto roleDto);
    void deleteRole(String id);
    Role findByName(String name);
}