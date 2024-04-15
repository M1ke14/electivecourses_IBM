package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="students")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float grade;

    @Column
    private int studyYear;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String facultySection;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
}
