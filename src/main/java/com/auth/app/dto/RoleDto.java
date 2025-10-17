package com.auth.app.dto;



public class RoleDto {
    private String roledtoID;
    private String name;
    private String description;
    
    
    
    
    public RoleDto() {
		super();
	}
    
	public RoleDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
    
	public RoleDto(String roledtoID, String name, String description) {
		super();
		this.roledtoID = roledtoID;
		this.name = name;
		this.description = description;
	}

	public String getRoledtoID() {
		return roledtoID;
	}

	public void setRoledtoID(String roledtoID) {
		this.roledtoID = roledtoID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
    
    
    
    
    
    
	
	
    
    
    
    
}
