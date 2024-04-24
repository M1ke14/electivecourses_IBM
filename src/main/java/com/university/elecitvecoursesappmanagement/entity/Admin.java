package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Admin() {

    }

    public Admin(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                '}';
    }
}
