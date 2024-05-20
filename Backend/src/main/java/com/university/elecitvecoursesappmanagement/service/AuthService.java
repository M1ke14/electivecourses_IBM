package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Admin;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthenticationService {

    private StudentRepository studentRepository;
    private AdminRepository adminRepository;
    public boolean loginStudent(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        if (student != null && student..equals(password) && "ROLE_STUDENT".equals(user.getRole())) {
            return true;
        }
        return false;
    }

    public boolean loginAdmin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && "ROLE_ADMIN".equals(user.getRole())) {
            return true;
        }
        return false;
    }
}
