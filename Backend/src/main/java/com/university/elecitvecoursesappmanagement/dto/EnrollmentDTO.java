package com.university.elecitvecoursesappmanagement.dto;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;

public class EnrollmentDTO {
    private Long id;
    private String priority;
    private Long studentId;
    private Long disciplineId;

    public EnrollmentDTO(Enrollment enrollment) {
        this.id = id;
        this.priority = priority;
        this.studentId = studentId;
        this.disciplineId = disciplineId;
    }

    // Getters and setters
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

}
