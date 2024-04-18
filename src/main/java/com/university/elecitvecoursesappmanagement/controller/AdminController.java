package com.university.elecitvecoursesappmanagement.controller;

import com.university.elecitvecoursesappmanagement.entity.Admin;
import com.university.elecitvecoursesappmanagement.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    AdminRepo adminRepo;

    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        try {
            List<Admin> adminList = new ArrayList<>();
            adminRepo.findAll().forEach(adminList::add); // return AdminRepo.forEach

            if(adminList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(adminList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> adminObj = adminRepo.findById(id);
        if(adminObj.isPresent()) {
            return new ResponseEntity<>(adminObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        try {
            Admin adminObj = adminRepo.save(admin);
            return new ResponseEntity<>(adminObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateAdmin/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        try {
            Optional<Admin> adminData = adminRepo.findById(id);
            if(adminData.isPresent()) {
                Admin updateAdminData = adminData.get();
                updateAdminData.setUser(admin.getUser());

                Admin adminObj = adminRepo.save(updateAdminData);
                return new ResponseEntity<>(adminObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAdminById/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable Long id) {
        try {
            adminRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllAdmin")
    public ResponseEntity<HttpStatus> deleteAllAdmin() {
        try {
            adminRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
