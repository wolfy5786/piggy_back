package com.piggyback.mapper;

import com.piggyback.dto.AdminDTO;
import com.piggyback.model.Admin;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdminMapper {
    public AdminDTO toDTO(Admin admin)
    {
        return new AdminDTO.Builder()
                .name(admin.getName())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .username(admin.getUsername())
                .password(admin.getPassword())
                .build();
    }
    public Admin newEntity(AdminDTO adminDTO)
    {
        return new Admin.Builder()
                .name(adminDTO.getName())
                .username(adminDTO.getUsername())
                .email(adminDTO.getEmail())
                .phone(adminDTO.getPhone())
                .password(adminDTO.getPassword())//from Dto
                .createdAt(LocalDateTime.now()) //created and updated now
                .updatedAt(LocalDateTime.now())
                .build(); //no id will be assigned by DB
    }
    public Admin updateEntity(AdminDTO adminDTO, Admin admin)
    {
        return new Admin.Builder()
                .name(adminDTO.getName()) //new fields
                .username(adminDTO.getUsername())
                .email(adminDTO.getEmail())
                .password(adminDTO.getPassword())
                .phone(adminDTO.getPhone()) //new fields *
                .createdAt(admin.getCreatedAt()) //from admin
                .updatedAt(LocalDateTime.now()) //updated now
                .userId(admin.getUserId()) //from admin
                .build();
    }
}
