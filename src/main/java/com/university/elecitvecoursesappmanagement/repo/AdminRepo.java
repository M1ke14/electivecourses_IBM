package com.university.elecitvecoursesappmanagement.repo;

import com.university.elecitvecoursesappmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
