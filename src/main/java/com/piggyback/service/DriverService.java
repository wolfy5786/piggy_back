package com.piggyback.service;

import com.piggyback.repository.DriverRepositary;
import com.piggyback.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class DriverService {

    DriverRepositary driverRepositary;

    @Autowired
    public DriverService(DriverRepositary driverRepositary)
    {
        this.driverRepositary = driverRepositary;
    }
}
