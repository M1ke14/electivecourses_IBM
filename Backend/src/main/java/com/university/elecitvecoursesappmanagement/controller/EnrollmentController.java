package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.dto.EnrollmentDTO;
import com.university.elecitvecoursesappmanagement.dto.StudentDTO;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    @Autowired
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/getAllEnrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        List<EnrollmentDTO> enrollmentDTOs = enrollments.stream()
                .map(EnrollmentDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(enrollmentDTOs);
    }

    @GetMapping("/getEnrollmentById/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollmentOptional = enrollmentService.getEnrollmentById(id);
        return enrollmentOptional.map(enrollment -> ResponseEntity.ok().body(new EnrollmentDTO(enrollment)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addEnrollment")
    public ResponseEntity<EnrollmentDTO> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment addedEnrollment = enrollmentService.addEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EnrollmentDTO(addedEnrollment));
    }

    @PutMapping("/updateEnrollment/{id}")
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if (updatedEnrollment != null) {
            return ResponseEntity.ok().body(new EnrollmentDTO(updatedEnrollment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEnrollmentById/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollmentById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllEnrollments")
    public ResponseEntity<Void> deleteAllStudents() {
        enrollmentService.deleteAllEnrollments();
        return ResponseEntity.noContent().build();
    }
}
