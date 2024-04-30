package com.university.elecitvecoursesappmanagement.repository;

import com.university.elecitvecoursesappmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
