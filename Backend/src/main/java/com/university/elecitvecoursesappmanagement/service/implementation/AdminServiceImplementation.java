package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.Admin;
import com.university.elecitvecoursesappmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements com.university.elecitvecoursesappmanagement.service.AdminService {
    @Autowired
    private final AdminRepository adminRepository;

    public AdminServiceImplementation(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin updateAdmin) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if(existingAdmin.isPresent()) {
            Admin adminToUpdate = existingAdmin.get();

            return adminRepository.save(adminToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public void deleteAllAdmins() {
        adminRepository.deleteAll();
    }

    @Override
    public boolean loginAdmin(Admin admin) {
        Optional<Admin> existingAdmin = adminRepository.findById(admin.getId());
        return existingAdmin.isPresent() && existingAdmin.get().getName().equals(admin.getName());
    }
}
