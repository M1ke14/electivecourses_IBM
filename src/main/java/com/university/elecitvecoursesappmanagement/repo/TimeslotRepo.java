package com.university.elecitvecoursesappmanagement.repo;

import com.university.elecitvecoursesappmanagement.entity.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeslotRepo extends JpaRepository<Timeslot, Long> {
}
