package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="admin")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
