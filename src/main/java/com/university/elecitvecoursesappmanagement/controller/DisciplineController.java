package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.service.implementation.DisciplineServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {
    @Autowired
    private final DisciplineServiceImplementation disciplineServiceImplementation;

    public DisciplineController(DisciplineServiceImplementation disciplineServiceImplementation) {
        this.disciplineServiceImplementation = disciplineServiceImplementation;
    }

    @GetMapping("getAllDisciplines")
    public List<Discipline> getAllDisciplines() {
        return disciplineServiceImplementation.getAllDiscipline();
    }

    @GetMapping("/getDisciplineById/{id}")
    public Optional<Discipline> getDisciplineById(@PathVariable Long id) {
        return disciplineServiceImplementation.getDisciplineById(id);
    }

    @PostMapping("/addDiscipline")
    public Discipline addDiscipline(@RequestBody Discipline discipline) {
        return disciplineServiceImplementation.addDiscipline(discipline);
    }

    @PostMapping("/updateDiscipline/{id}")
    public Discipline updateDiscipline(@PathVariable Long id, @RequestBody Discipline discipline) {
        return disciplineServiceImplementation.updateDiscipline(id, discipline);
    }

    @DeleteMapping("/deleteDisciplineById/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
        disciplineServiceImplementation.deleteDisciplineById(id);
    }

    @DeleteMapping("/deleteAllDisciplines")
    public void deleteAllUsers() {
        disciplineServiceImplementation.deleteAllDisciplines();
    }
}
