package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.dto.StudentDTO;
import com.university.elecitvecoursesappmanagement.dto.StudentLoginDTO;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOs = students.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(studentDTOs);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.getStudentById(id);
        return studentOptional.map(student -> ResponseEntity.ok().body(new StudentDTO(student)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentDTO(addedStudent));
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok().body(new StudentDTO(updatedStudent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/loginStudent")
    public ResponseEntity<Void> login(@RequestBody StudentLoginDTO studentLoginDTO) {
        Student student = new Student();
        student.setId(studentLoginDTO.getId());
        student.setName(studentLoginDTO.getName());

        boolean isAuthenticated = studentService.loginStudent(student);
        if (isAuthenticated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.noContent().build();
    }
}
