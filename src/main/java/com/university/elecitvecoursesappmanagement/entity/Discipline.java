package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "discipline")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int maxStudents;

    @Column
    private int studyYear;

    @Column
    private int category;

    @Column
    private String teacher;

    @OneToMany(mappedBy = "discipline")
    private List<Enrollment> enrollments;
}
