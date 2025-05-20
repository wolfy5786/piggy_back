package com.piggyback.service;

import com.piggyback.model.Customer;
import com.piggyback.repository.DriverRepository;
import com.piggyback.model.Driver;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

public class DriverService {

    DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }

    public Optional<Driver> getDriverById(Integer userId) {
        return driverRepository.findById(userId);
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
    public Driver createDriver(@NotNull Driver driver) {
        if (!driverRepository.findByUsername(driver.getUsername()).isPresent())
        {
            return driverRepository.save(driver);
        }
        return null;
    }
    public boolean updateDriver(@NotNull Driver driver)
    {
        if(driverRepository.findByUsername(driver.getUsername()).isPresent())
        {
            Driver new_record = driverRepository.findByUsername(driver.getUsername()).get().copy_records(driver);
            new_record.setUpdatedAt(LocalDateTime.now());
            driverRepository.save(new_record);
            return true;
        }
        return false;
    }

    public boolean deleteDriver(@NotNull Driver driver) {
        var cust = driverRepository.findByUsername(driver.getUsername());
        if (cust.isPresent())
        {
            driverRepository.delete(cust.get());
            return true;
        }
        return false;
    }
    public Driver getDriverByUsername(String username)
    {
        var cust = driverRepository.findByUsername(username);
        if(cust.isPresent())
        {
            return cust.get();
        }
        return null;
    }


}
