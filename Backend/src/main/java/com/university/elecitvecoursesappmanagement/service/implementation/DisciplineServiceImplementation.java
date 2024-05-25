package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.Discipline;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImplementation implements com.university.elecitvecoursesappmanagement.service.DisciplineService {
    @Autowired
    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImplementation(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<Discipline> getAllDiscipline() {
        return disciplineRepository.findAll();
    }

    @Override
    public Optional<Discipline> getDisciplineById(Long id) {
        return disciplineRepository.findById(id);
    }

    @Override
    public Discipline addDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public Discipline updateDiscipline(Long id, Discipline updateDiscipline) {
        Optional<Discipline> existingDiscipline = disciplineRepository.findById(id);
        if(existingDiscipline.isPresent()) {
            Discipline disciplineToUpdate = existingDiscipline.get();
            disciplineToUpdate.setName(updateDiscipline.getName());
            disciplineToUpdate.setMaxStudents(updateDiscipline.getMaxStudents());
            disciplineToUpdate.setStudyYear(updateDiscipline.getStudyYear());
            disciplineToUpdate.setCategory(updateDiscipline.getCategory());
            disciplineToUpdate.setTeacher(updateDiscipline.getTeacher());
            disciplineToUpdate.setEnrollments(updateDiscipline.getEnrollments());

            return disciplineRepository.save(disciplineToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteDisciplineById(Long id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public void deleteAllDisciplines() {
        disciplineRepository.deleteAll();
    }

    public List<Discipline> getDisciplinesForStudent(Student student) {
        return disciplineRepository.findByStudyYearAndCategory(student.getStudyYear(), student.getFacultySection());
    }
}
