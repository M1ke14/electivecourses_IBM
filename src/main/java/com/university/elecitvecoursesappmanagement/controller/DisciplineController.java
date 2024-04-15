package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.repo.DisciplineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DisciplineController {
    @Autowired
    DisciplineRepo disciplineRepo;

    @GetMapping("getAllDisciplines")
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        try {
            List<Discipline> disciplineList = new ArrayList<>();
            disciplineRepo.findAll().forEach(disciplineList::add);

            if(disciplineList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(disciplineList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDisciplineById/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable Long id) {
        Optional<Discipline> disciplineObj = disciplineRepo.findById(id);
        if(disciplineObj.isPresent()) {
            return new ResponseEntity<>(disciplineObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addDiscipline")
    public ResponseEntity<Discipline> addDiscipline(@RequestBody Discipline discipline) {
        try {
            Discipline disciplineObj = disciplineRepo.save(discipline);
            return new ResponseEntity<>(disciplineObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateDiscipline/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable Long id, @RequestBody Discipline discipline) {
        try {
            Optional<Discipline> disciplineData = disciplineRepo.findById(id);
            if(disciplineData.isPresent()) {
                Discipline updateDisciplineData = disciplineData.get();
                updateDisciplineData.setName(discipline.getName());
                updateDisciplineData.setMaxStudents(discipline.getMaxStudents());
                updateDisciplineData.setStudyYear(discipline.getStudyYear());
                updateDisciplineData.setCategory(discipline.getCategory());


                Discipline disciplineObj = disciplineRepo.save(updateDisciplineData);
                return new ResponseEntity<>(discipline, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteDisciplineById/{id}")
    public ResponseEntity<HttpStatus> deleteDiscipline(@PathVariable Long id) {
        try {
            disciplineRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllDisciplines")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            disciplineRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
