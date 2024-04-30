package com.university.elecitvecoursesappmanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="students")
public class Student extends User {
    @Column
    private float grade;

    @Column
    private int studyYear;

    @Column
    private String facultySection;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    public Student() {

    }

    public Student(String name, String userType, float grade, int studyYear, String facultySection, List<Enrollment> enrollments) {
        super(name, userType);
        this.grade = grade;
        this.studyYear = studyYear;
        this.facultySection = facultySection;
        this.enrollments = enrollments;
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
                ", grade=" + grade +
                ", studyYear=" + studyYear +
                ", facultySection='" + facultySection + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
