package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student addStudent(Student student);

    Student updateStudent(Long id, Student updateStudent);

    void deleteStudentById(Long id);

    void deleteAllStudents();

    boolean loginStudent(Student student);
}
