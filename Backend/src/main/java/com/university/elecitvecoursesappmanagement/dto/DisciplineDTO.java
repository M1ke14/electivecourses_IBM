package com.university.elecitvecoursesappmanagement.dto;

import com.university.elecitvecoursesappmanagement.entity.Discipline;

public class DisciplineDTO {
    private Long id;
    private String name;
    private int maxStudents;
    private int studyYear;
    private String category;
    private String teacher;

    public DisciplineDTO() {}

    public DisciplineDTO(Discipline discipline) {
        this.id = discipline.getId();
        this.name = discipline.getName();
        this.maxStudents = discipline.getMaxStudents();
        this.studyYear = discipline.getStudyYear();
        this.category = discipline.getCategory();
        this.teacher = discipline.getTeacher();
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
