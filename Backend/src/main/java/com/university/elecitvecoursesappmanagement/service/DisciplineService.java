package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    List<Discipline> getAllDiscipline();

    Optional<Discipline> getDisciplineById(Long id);

    Discipline addDiscipline(Discipline discipline);

    Discipline updateDiscipline(Long id, Discipline updateDiscipline);

    void deleteDisciplineById(Long id);

    void deleteAllDisciplines();
}
