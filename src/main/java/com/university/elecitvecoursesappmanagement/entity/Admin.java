package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Admin() {

    }

    public Admin(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Admin(Long id, String name, String userType, Long id1, User user) {
        super(id, name, userType);
        this.id = id1;
        this.user = user;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
