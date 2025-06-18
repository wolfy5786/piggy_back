package com.piggyback.service;

import com.piggyback.mapper.AdminMapper;
import com.piggyback.model.Admin;
import com.piggyback.repository.AdminRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminService {

    //@Autowired
    private AdminRepository adminRepository;
    private AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper)
    {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }


    public Admin getAdminByUsername(String username) {
        if(adminRepository.findByUsername(username).isPresent()) {
            return adminRepository.findByUsername(username).get();
        }
        return null;
    }

    public Admin createAdmin (@NotNull Admin admin) {
        if (!adminRepository.findByUsername(admin.getUsername()).isPresent())// check if already exists
        {
            return adminRepository.save(admin);
        }
        return null;
    }
    public boolean deleteAdmin(@NotNull Admin admin)
    {
        if (adminRepository.findByUsername(admin.getUsername()).isPresent()) {
            adminRepository.delete(adminRepository.findByUsername(admin.getUsername()).get());
            return true;
        }
        return false;
    }

    public boolean updateAdmin(@NotNull Admin admin)
    {
        if (adminRepository.findByUsername(admin.getUsername()).isPresent())
        {
            Admin updated_record = adminRepository.findByUsername(admin.getUsername()).get().copy_records(admin);
            updated_record.setUpdatedAt(LocalDateTime.now());
            adminRepository.save(updated_record);
            return true;
        }
        return false;
    }

    public Admin getAdminByEmail(String email)
    {
        if(adminRepository.findByEmail(email).isPresent())
        {
            return adminRepository.findByEmail(email).get();
        }
        return null;
    }

}
