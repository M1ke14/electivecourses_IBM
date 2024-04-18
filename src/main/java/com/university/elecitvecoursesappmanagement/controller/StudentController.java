package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.repo.StudentRepo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> studentList = new ArrayList<>();
            studentRepo.findAll().forEach(studentList::add);

            if(studentList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(studentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> studentObj = studentRepo.findById(id);
        if(studentObj.isPresent()) {
            return new ResponseEntity<>(studentObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            Student studentObj = studentRepo.save(student);
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            Optional<Student> studentData = studentRepo.findById(id);
            if(studentData.isPresent()) {
                Student updateStudentData = studentData.get();
                updateStudentData.setGrade(student.getGrade());
                updateStudentData.setStudyYear(student.getStudyYear());
                updateStudentData.setFacultySection(student.getFacultySection());
                updateStudentData.setEnrollments(student.getEnrollments());

                Student studentObj = studentRepo.save(updateStudentData);
                return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        try {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            studentRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
