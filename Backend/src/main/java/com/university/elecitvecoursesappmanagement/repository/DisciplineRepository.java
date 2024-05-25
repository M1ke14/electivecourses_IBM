package com.university.elecitvecoursesappmanagement.repository;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findByStudyYearAndCategory(int studyYear, String category);
}
