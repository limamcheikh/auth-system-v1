package com.auth.app.dto;


public class RegisterResponse {
    private String id;
    private String username;
    private String email;
    private String message;
    private Boolean success;
    
    public RegisterResponse() {}
    
    public RegisterResponse(String id, String username, String email, String message, Boolean success) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.message = message;
        this.success = success;
    }
    
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
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
