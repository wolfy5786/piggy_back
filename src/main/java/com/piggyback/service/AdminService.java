package com.piggyback.service;

import com.piggyback.dto.AdminDTO;
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
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) //Spring injects there object (loose coupling)
    {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }


    public AdminDTO getAdminByUsername(String username) {
        Optional <Admin> admin = adminRepository.findByUsername(username);
        if(admin.isPresent()) {
            return adminMapper.toDTO(admin.get());
        }
        return null; // should we return null?
    }

    public void createAdmin (@NotNull AdminDTO adminDTO) { //switch to AdminDto here
        Optional<Admin> admin = adminRepository.findByUsername(adminDTO.getUsername());
        if (!admin.isPresent())// check if already exists, change to throws exception
        {
            adminMapper.toDTO(adminRepository.save(adminMapper.newEntity(adminDTO)));
        }
    }
    public boolean deleteAdmin(@NotNull AdminDTO adminDTO) // switch to dto
    {
        Optional<Admin> admin = adminRepository.findByUsername(adminDTO.getUsername());
        if (admin.isPresent()) {
            adminRepository.delete(admin.get());
            return true;
        }
        return false;
    }

    public boolean updateAdmin(@NotNull AdminDTO adminDTO)
    {
        Optional <Admin> admin =  adminRepository.findByUsername(adminDTO.getUsername());
        if (admin.isPresent())
        {
            Admin newAdmin = adminMapper.updateEntity(adminDTO,admin.get());
            adminRepository.save(newAdmin);
            return true;
        }
        return false;
    }

    public AdminDTO getAdminByEmail(String email)
    {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if(admin.isPresent())
        {
            return adminMapper.toDTO(admin.get());
        }
        return null;
    }

}
