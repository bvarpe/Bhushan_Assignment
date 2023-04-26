package com.example.crudoperations.dto;

public class SalesRepDto{

    private String id;
    private String firstName;
    private String lastName;
    private String arcId;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArcId() {
        return arcId;
    }

    public void setArcId(String arcId) {
        this.arcId = arcId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
