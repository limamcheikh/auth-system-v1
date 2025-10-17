package com.auth.app.dto;


import java.util.Set;


public class LoginResponse {
    private String token;
    private String refreshToken;
    private String username;
    private Set<String> roles;
    private Long expiresIn;
	public LoginResponse(String token, String refreshToken, String username, Set<String> roles, Long expiresIn) {
		super();
		this.token = token;
		this.refreshToken = refreshToken;
		this.username = username;
		this.roles = roles;
		this.expiresIn = expiresIn;
	}
	public LoginResponse() {
		super();
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
    
    
    
    
}
