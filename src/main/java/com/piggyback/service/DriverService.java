package com.piggyback.service;

import com.piggyback.dto.DriverDTO;
import com.piggyback.mapper.CabMapper;
import com.piggyback.mapper.DriverMapper;
import com.piggyback.model.Customer;
import com.piggyback.repository.DriverRepository;
import com.piggyback.model.Driver;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper)
    {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
    public boolean createDriver(@NotNull DriverDTO driverDTO) {
        Optional<Driver> driver = driverRepository.findByUsername(driverDTO.getUsername());
        if (!driver.isPresent())
        {
            driverRepository.save(driverMapper.newEntity(driverDTO));
            return true;
        }
        return false;
    }
    public boolean updateDriver(@NotNull DriverDTO driverDTO)
    {
        Optional<Driver> driver = driverRepository.findByUsername(driverDTO.getUsername());
        if(driver.isPresent())
        {
            driverRepository.save(driverMapper.updateEntity(driverDTO,driver.get()));
            return true;
        }
        return false;
    }

    public boolean deleteDriver(@NotNull DriverDTO driverDTO) {
        Optional<Driver> driver = driverRepository.findByUsername(driverDTO.getUsername());
        if (driver.isPresent())
        {
            driverRepository.delete(driver.get());
            return true;
        }
        return false;
    }
    public Driver getDriverByUsername(String username)
    {
        Optional<Driver> driver = driverRepository.findByUsername(username);
        if(driver.isPresent())
        {
            return driver.get();
        }
        return null;
    }


}
