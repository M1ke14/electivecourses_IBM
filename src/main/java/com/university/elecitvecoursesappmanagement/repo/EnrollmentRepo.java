package com.university.elecitvecoursesappmanagement.repo;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
