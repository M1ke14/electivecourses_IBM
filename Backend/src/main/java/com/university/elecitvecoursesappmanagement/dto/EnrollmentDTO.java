package com.university.elecitvecoursesappmanagement.dto;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;

public class EnrollmentDTO {
    private Long id;
    private String priority;
    private String studentName;
    private String disciplineName;

    public EnrollmentDTO(Enrollment enrollment) {
        this.id = enrollment.getId();
        this.priority = enrollment.getPriority();
        this.studentName = enrollment.getStudent().getName();
        this.disciplineName = enrollment.getDiscipline().getName();
    }

    public EnrollmentDTO(Long id, String priority, String studentName, String disciplineName) {
        this.id = id;
        this.priority = priority;
        this.studentName = studentName;
        this.disciplineName = disciplineName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}
