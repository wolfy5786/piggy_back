package com.piggyback.mapper;

import com.piggyback.dto.DriverDTO;
import com.piggyback.model.Driver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DriverMapper {
    public DriverDTO toDTO(Driver driver)
    {
        return new DriverDTO.Builder()
                .name(driver.getName())
                .email(driver.getEmail())
                .username(driver.getUsername())
                .password(driver.getPassword())
                .phone(driver.getPhone())
                .driverStatus(driver.getDriverStatus())
                .driverRating(driver.getDriverRating())
                .build();
    }
    public Driver newEntity(DriverDTO driverDTO)
    {
        return new Driver.Builder()
                .name(driverDTO.getName())
                .email(driverDTO.getEmail())
                .username(driverDTO.getUsername())
                .password(driverDTO.getPassword())
                .phone(driverDTO.getPhone())
                .driverStatus(driverDTO.getDriverStatus())
                .driverRating(driverDTO.getDriverRating())
                .createdAt(LocalDateTime.now()) //created just now
                .updatedAt(LocalDateTime.now())
                .build(); //no id
    }
    public Driver updateEntity(DriverDTO driverDTO, Driver driver)
    {
        return new Driver.Builder()
                .name(driverDTO.getName())
                .email(driverDTO.getEmail())
                .username(driverDTO.getUsername())
                .password(driverDTO.getPassword())
                .phone(driverDTO.getPhone())
                .driverStatus(driverDTO.getDriverStatus())
                .driverRating(driverDTO.getDriverRating())
                .userId(driver.getUserId()) //from Driver
                .createdAt(driver.getCreatedAt())
                .updatedAt(LocalDateTime.now()) //updated just now
                .build();
    }
}
