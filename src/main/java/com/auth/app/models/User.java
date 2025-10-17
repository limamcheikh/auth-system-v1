package com.auth.app.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userID;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private Boolean enabled = true;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    
    
    // =======================
    // Constructors
    // =======================
    
    
    public User() {
		super();
	}
    
    
    
    public User(String userID, String username, String email, String password, Boolean enabled, Set<Role> roles,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.userID = userID;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    


	public User(String username, String email, String password, Boolean enabled, Set<Role> roles,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    
    
    
    
    
    
    
    public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
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


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	@PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    


	@PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
