package com.piggyback.service;

import com.piggyback.repository.DriverRepository;
import com.piggyback.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class DriverService {

    DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository)
    {
        this.driverRepository = driverRepository;
    }
    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Optional<Driver> getDriverById(Integer userId) {
        return driverRepository.findById(userId);
    }

    public Iterable<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public void deleteDriver(Integer userId) {
        driverRepository.deleteById(userId);
    }

    public boolean driverExists(Integer userId) {
        return driverRepository.existsById(userId);
    }
}
