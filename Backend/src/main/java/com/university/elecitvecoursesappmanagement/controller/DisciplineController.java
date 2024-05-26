package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.dto.DisciplineDTO;
import com.university.elecitvecoursesappmanagement.dto.StudentDTO;
import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.service.implementation.DisciplineServiceImplementation;
import com.university.elecitvecoursesappmanagement.service.implementation.StudentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {
    @Autowired
    private final DisciplineServiceImplementation disciplineService;

    @Autowired
    private StudentServiceImplementation studentService;

    @Autowired
    public DisciplineController(DisciplineServiceImplementation disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("getAllDisciplines")
    public ResponseEntity<List<DisciplineDTO>> getAllDisciplines() {
        List<Discipline> disciplines = disciplineService.getAllDiscipline();
        List<DisciplineDTO> disciplineDTOs = disciplines.stream()
                .map(DisciplineDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(disciplineDTOs);
    }

    @GetMapping("/getDisciplineById/{id}")
    public ResponseEntity<DisciplineDTO> getDisciplineById(@PathVariable Long id) {
        Optional<Discipline> disciplineOptional = disciplineService.getDisciplineById(id);
        return disciplineOptional.map(discipline -> ResponseEntity.ok().body(new DisciplineDTO(discipline)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addDiscipline")
    public ResponseEntity<DisciplineDTO> addDiscipline(@RequestBody Discipline discipline) {
        Discipline addedDiscipline = disciplineService.addDiscipline(discipline);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DisciplineDTO(addedDiscipline));
    }

    @PutMapping("/updateDiscipline/{id}")
    public ResponseEntity<DisciplineDTO> updateDiscipline(@PathVariable Long id, @RequestBody Discipline discipline) {
        Discipline updatedDiscipline = disciplineService.updateDiscipline(id, discipline);
        if (updatedDiscipline != null) {
            return ResponseEntity.ok().body(new DisciplineDTO(updatedDiscipline));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteDisciplineById/{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteDisciplineById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllDisciplines")
    public ResponseEntity<Void> deleteAllStudents() {
        disciplineService.deleteAllDisciplines();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/student-disciplines/{studentId}")
    public ResponseEntity<List<DisciplineDTO>> getDisciplinesForStudent(@PathVariable Long studentId) {
        Optional<Student> studentOpt = studentService.getStudentById(studentId);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            List<Discipline> disciplines = disciplineService.getDisciplinesForStudent(student);
            List<DisciplineDTO> disciplineDTOs = disciplines.stream()
                    .map(DisciplineDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(disciplineDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}