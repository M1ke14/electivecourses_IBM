package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.dto.AdminLoginDTO;
import com.university.elecitvecoursesappmanagement.entity.Admin;
import com.university.elecitvecoursesappmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok().body(admins);
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.getAdminById(id);
        return adminOptional.map(admin -> ResponseEntity.ok().body(admin))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin addedAdmin = adminService.addAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAdmin);
    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        if (updatedAdmin != null) {
            return ResponseEntity.ok().body(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteAdminById/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAllAdmins")
    public ResponseEntity<Void> deleteAllAdmins() {
        adminService.deleteAllAdmins();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<Void> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        Admin admin = new Admin();
        admin.setId(adminLoginDTO.getId());
        admin.setName(adminLoginDTO.getName());

        boolean isAuthenticated = adminService.loginAdmin(admin);
        if (isAuthenticated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
