package com.auth.app.services;

import org.springframework.stereotype.Service;

import com.auth.app.dto.RoleDto;
import com.auth.app.models.Role;
import com.auth.app.ripository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = new Role();  // Use default constructor
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        Role saved = roleRepository.save(role);
        return mapToDto(saved);
    }

    @Override
    public RoleDto getRoleById(String id) {
        return roleRepository.findById(id)
            .map(this::mapToDto)
            .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public RoleDto getRoleByName(String name) {
        return roleRepository.findByName(name)
            .map(this::mapToDto)
            .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll()
            .stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    @Override
    public RoleDto updateRole(String id, RoleDto roleDto) {
        Role role = roleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Role not found"));
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        Role updated = roleRepository.save(role);
        return mapToDto(updated);
    }

    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    private RoleDto mapToDto(Role role) {
        RoleDto dto = new RoleDto(); // Use default constructor
        dto.setRoledtoID(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());
        return dto;
    }
}
