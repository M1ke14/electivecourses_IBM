package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(Long id);

    Admin addAdmin(Admin admin);

    Admin updateAdmin(Long id, Admin updateAdmin);

    void deleteAdminById(Long id);

    void deleteAllAdmins();

    boolean loginAdmin(Admin admin);
}