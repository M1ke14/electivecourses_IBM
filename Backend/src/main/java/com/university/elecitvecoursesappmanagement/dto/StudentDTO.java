package com.university.elecitvecoursesappmanagement.dto;

import com.university.elecitvecoursesappmanagement.entity.Student;

public class StudentDTO {
    private Long id;
    private String name;
    private String userType;
    private float grade;
    private int studyYear;
    private String facultySection;

    public StudentDTO() {
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.userType = student.getUserType();
        this.grade = student.getGrade();
        this.studyYear = student.getStudyYear();
        this.facultySection = student.getFacultySection();
    }

    // Getters and setters
    // Include getters and setters for all fields

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    // Override toString method if needed
}
