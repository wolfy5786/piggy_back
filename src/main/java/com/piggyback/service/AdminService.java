package com.piggyback.service;

import com.piggyback.model.Admin;
import com.piggyback.repository.AdminRepository;
import com.piggyback.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

//    public Admin createAdmin(Admin admin) {
//        // You could hash the password here if needed
//        admin.setRole(Role.ADMIN);
//        admin.setCreatedAt(LocalDateTime.now());
//        return adminRepository.save(admin);
//    }

    public Optional<Admin> getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
