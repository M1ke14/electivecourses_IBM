package com.university.elecitvecoursesappmanagement.repository;

import com.university.elecitvecoursesappmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
