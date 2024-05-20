package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.dto.EnrollmentDTO;
import com.university.elecitvecoursesappmanagement.entity.Enrollment;
import com.university.elecitvecoursesappmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImplementation implements com.university.elecitvecoursesappmanagement.service.EnrollmentService {
    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImplementation(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollment -> {
                    String studentName = enrollment.getStudent() != null ? enrollment.getStudent().getName() : null;
                    String disciplineName = enrollment.getDiscipline() != null ? enrollment.getDiscipline().getName() : null;
                    return new EnrollmentDTO(enrollment.getId(), enrollment.getPriority(), studentName, disciplineName);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EnrollmentDTO> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .map(enrollment -> {
                    String studentName = enrollment.getStudent() != null ? enrollment.getStudent().getName() : null;
                    String disciplineName = enrollment.getDiscipline() != null ? enrollment.getDiscipline().getName() : null;
                    return new EnrollmentDTO(enrollment.getId(), enrollment.getPriority(), studentName, disciplineName);
                });
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment updateEnrollment) {
        Optional<Enrollment> existingEnrollmentOpt = enrollmentRepository.findById(id);
        if(existingEnrollmentOpt.isPresent()) {
            Enrollment existingEnrollment = existingEnrollmentOpt.get();
            existingEnrollment.setPriority(updateEnrollment.getPriority());

            if (updateEnrollment.getStudent() != null) {
                existingEnrollment.setStudent(updateEnrollment.getStudent());
            }
            if (updateEnrollment.getDiscipline() != null) {
                existingEnrollment.setDiscipline(updateEnrollment.getDiscipline());
            }

            return enrollmentRepository.save(existingEnrollment);
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
