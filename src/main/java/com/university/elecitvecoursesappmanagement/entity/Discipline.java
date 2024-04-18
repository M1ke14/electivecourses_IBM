package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "discipline")
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

    public Discipline() {

    }

    public Discipline(Long id, String name, int maxStudents, int studyYear, int category, String teacher, List<Enrollment> enrollments) {
        this.id = id;
        this.name = name;
        this.maxStudents = maxStudents;
        this.studyYear = studyYear;
        this.category = category;
        this.teacher = teacher;
        this.enrollments = enrollments;
    }

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

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxStudents=" + maxStudents +
                ", studyYear=" + studyYear +
                ", category=" + category +
                ", teacher='" + teacher + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
