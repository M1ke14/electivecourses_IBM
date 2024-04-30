package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Admin;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();

    Optional<Enrollment> getEnrollmentById(Long id);

    Enrollment addEnrollment(Enrollment enrollment);

    Enrollment updateEnrollment(Long id, Enrollment updateEnrollment);

    void deleteEnrollmentById(Long id);

    void deleteAllEnrollments();
}
