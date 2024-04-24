package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.service.StudentServiceImplementation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private final StudentServiceImplementation studentServiceImplementation;

    public StudentController(StudentServiceImplementation studentServiceImplementation) {
        this.studentServiceImplementation = studentServiceImplementation;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentServiceImplementation.getAllStudents();
    }

    @GetMapping("/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentServiceImplementation.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentServiceImplementation.addStudent(student);
    }

    @PostMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentServiceImplementation.updateStudent(id, student);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentServiceImplementation.deleteStudentById(id);
    }

    @DeleteMapping("/deleteAllStudents")
    public void deleteAllStudents() {
        studentServiceImplementation.deleteAllStudents();
    }
}
