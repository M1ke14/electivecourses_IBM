package com.university.elecitvecoursesappmanagement.dto;

import com.university.elecitvecoursesappmanagement.entity.Admin;

public class AdminDTO {
    private Long id;
    private String name;

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }
}
