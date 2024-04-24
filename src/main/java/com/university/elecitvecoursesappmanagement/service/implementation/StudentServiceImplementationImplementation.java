package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.entity.Student;
import com.university.elecitvecoursesappmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementationImplementation implements com.university.elecitvecoursesappmanagement.service.StudentServiceImplementation {
    @Autowired
    private final StudentRepository studentRepository;


    public StudentServiceImplementationImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updateStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setGrade(updateStudent.getGrade());
            studentToUpdate.setStudyYear(updateStudent.getStudyYear());
            studentToUpdate.setFacultySection(updateStudent.getFacultySection());
            studentToUpdate.setEnrollments(updateStudent.getEnrollments());

            return studentRepository.save(studentToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
}
