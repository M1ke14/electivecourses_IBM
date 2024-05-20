package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.dto.EnrollmentDTO;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<EnrollmentDTO> getAllEnrollments();

    Optional<EnrollmentDTO> getEnrollmentById(Long id);

    Enrollment addEnrollment(Enrollment enrollment);

    Enrollment updateEnrollment(Long id, Enrollment updateEnrollment);

    void deleteEnrollmentById(Long id);

    void deleteAllEnrollments();
}
