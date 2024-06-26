package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String priority;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Enrollment() {

    }

    public Enrollment(Long id, String priority, Student student, Discipline discipline) {
        this.id = id;
        this.priority = priority;
        this.student = student;
        this.discipline = discipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", priority=" + priority +
                ", student=" + student +
                ", discipline=" + discipline +
                '}';
    }
}
