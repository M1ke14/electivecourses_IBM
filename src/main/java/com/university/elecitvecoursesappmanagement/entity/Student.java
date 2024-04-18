package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="students")
public class Student extends User {
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

    public Student() {

    }

    public Student(Long id, float grade, int studyYear, User user, String facultySection, List<Enrollment> enrollments) {
        this.id = id;
        this.grade = grade;
        this.studyYear = studyYear;
        this.user = user;
        this.facultySection = facultySection;
        this.enrollments = enrollments;
    }

    public Student(Long id, String name, String userType, Long id1, float grade, int studyYear, User user, String facultySection, List<Enrollment> enrollments) {
        super(id, name, userType);
        this.id = id1;
        this.grade = grade;
        this.studyYear = studyYear;
        this.user = user;
        this.facultySection = facultySection;
        this.enrollments = enrollments;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFacultySection() {
        return facultySection;
    }

    public void setFacultySection(String facultySection) {
        this.facultySection = facultySection;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", grade=" + grade +
                ", studyYear=" + studyYear +
                ", user=" + user +
                ", facultySection='" + facultySection + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
