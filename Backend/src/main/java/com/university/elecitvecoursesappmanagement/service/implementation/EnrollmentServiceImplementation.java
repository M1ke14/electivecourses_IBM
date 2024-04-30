package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImplementation implements com.university.elecitvecoursesappmanagement.service.EnrollmentService {
    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImplementation(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment updateEnrollment) {
        Optional<Enrollment> existingEnrollment = enrollmentRepository.findById(id);
        if(existingEnrollment.isPresent()) {
            Enrollment enrollmentToUpdate = existingEnrollment.get();
            enrollmentToUpdate.setPriority(updateEnrollment.getPriority());
            enrollmentToUpdate.setStudent(updateEnrollment.getStudent());
            enrollmentToUpdate.setDiscipline(updateEnrollment.getDiscipline());

            return enrollmentRepository.save(enrollmentToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEnrollmentById(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public void deleteAllEnrollments() {
        enrollmentRepository.deleteAll();
    }
}
