package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.dto.EnrollmentDTO;
import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.service.DisciplineService;
import com.university.elecitvecoursesappmanagement.service.EnrollmentService;
import com.university.elecitvecoursesappmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    @Autowired
    private final EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private DisciplineService disciplineService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/getAllEnrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments() {
        List<EnrollmentDTO> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok().body(enrollments);
    }

    @GetMapping("/getEnrollmentById/{id}")
    public ResponseEntity<EnrollmentDTO> getEnrollmentById(@PathVariable Long id) {
        Optional<EnrollmentDTO> enrollmentOptional = enrollmentService.getEnrollmentById(id);
        return enrollmentOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addEnrollment")
    public ResponseEntity<EnrollmentDTO> addEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment addedEnrollment = enrollmentService.addEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EnrollmentDTO(addedEnrollment));
    }

    @PutMapping("/updateEnrollment/{id}")
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        // Validate student and discipline
        if (enrollment.getStudent() == null || enrollment.getDiscipline() == null) {
            return null;
        }

        // Check if student and discipline exist (implement these methods in the respective services)
        Optional<Student> studentOpt = studentService.getStudentById(enrollment.getStudent().getId());
        Optional<Discipline> disciplineOpt = disciplineService.getDisciplineById(enrollment.getDiscipline().getId());

        if (!studentOpt.isPresent() || !disciplineOpt.isPresent()) {
            return null;
        }

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
