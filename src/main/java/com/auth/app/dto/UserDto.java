package com.auth.app.dto;

import java.util.List;

public class UserDto {

    private String id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private List<RoleDto> roles;

    // =======================
    // Constructors
    // =======================

    public UserDto() {
    }

    public UserDto(String id, String username, String email, String password, List<RoleDto> roles,boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
    }

    // =======================
    // Getters and Setters
    // =======================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

