package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.User;
import com.university.elecitvecoursesappmanagement.repo.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EnrollmentController {
    @Autowired
    EnrollmentRepo enrollmentRepo;

    @GetMapping("/getAllEnrollments")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        try {
            List<Enrollment> enrollmentList = new ArrayList<>();
            enrollmentRepo.findAll().forEach(enrollmentList::add);

            if(enrollmentList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(enrollmentList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEnrollmentById")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollmentObj = enrollmentRepo.findById(id);
        if(enrollmentObj.isPresent()) {
            return new ResponseEntity<>(enrollmentObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addEnrollment")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        try {
            Enrollment enrollmentObj = enrollmentRepo.save(enrollment);
            return new ResponseEntity<>(enrollmentObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateEnrollment/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        try {
            Optional<Enrollment> enrollmentData = enrollmentRepo.findById(id);
            if(enrollmentData.isPresent()) {
                Enrollment updateEnrollmentData = enrollmentData.get();
                updateEnrollmentData.setPriority(enrollment.getPriority());

                Enrollment enrollmentObj = enrollmentRepo.save(updateEnrollmentData);
                return new ResponseEntity<>(enrollmentObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEnrollmentById/{id}")
    public ResponseEntity<HttpStatus> deleteEnrollment(@PathVariable Long id) {
        try {
            enrollmentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllEnrollments")
    public ResponseEntity<HttpStatus> deleteAllEnrollments() {
        try {
            enrollmentRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
