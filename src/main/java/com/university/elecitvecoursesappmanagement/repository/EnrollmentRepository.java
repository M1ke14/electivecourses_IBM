package com.university.elecitvecoursesappmanagement.repository;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
