package com.university.elecitvecoursesappmanagement.dto;

public class AdminLoginDTO {
    private Long id;
    private String name;

    // Constructors
    public AdminLoginDTO() {
    }

    public AdminLoginDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
