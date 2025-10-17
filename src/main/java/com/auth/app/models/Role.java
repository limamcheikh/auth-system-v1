package com.auth.app.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleID;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // =======================
    // Constructors
    // =======================
    public Role() {
    }

    public Role(String roleID, String name, String description, LocalDateTime createdAt) {
        this.roleID = roleID;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }
    
    public Role(String name, String description, LocalDateTime createdAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    // =======================
    // Getters and Setters
    // =======================
    public String getId() {
        return this.roleID;
    }

    public void setId(String id) {
        this.roleID = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // =======================
    // PrePersist
    // =======================
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
