package com.piggyback.service;

import com.piggyback.model.Cab;
import com.piggyback.repository.CabRepositary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class CabService {
    private final CabRepositary cabRepositary;

    @Autowired
    public CabService(CabRepositary cabRepositary)
    {
        this.cabRepositary = cabRepositary;
    }


}
