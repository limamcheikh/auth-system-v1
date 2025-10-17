package com.auth.app.services;


import java.util.List;
import java.util.Optional;

import com.auth.app.dto.RegisterRequest;
import com.auth.app.dto.UserDto;
import com.auth.app.models.User;

public interface UserService {
	UserDto createUser(RegisterRequest request);
    Optional<UserDto> getUserById(String id);
    Optional<UserDto> getUserByUsername(String username);
    Optional<UserDto> getUserByEmail(String email);
    List<UserDto> getAllUsers();
    UserDto updateUser(String id, UserDto user);
    void deleteUser(String id);
    void assignRoleToUser(String userId, String roleId);
    void removeRoleFromUser(String userId, String roleId);
}
