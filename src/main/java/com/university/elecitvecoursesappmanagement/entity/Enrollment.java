package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="enrollment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float priority;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
}
