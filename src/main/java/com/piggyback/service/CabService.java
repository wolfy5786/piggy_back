package com.piggyback.service;

import com.piggyback.model.Cab;
import com.piggyback.repository.CabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class CabService {
    private final CabRepository cabRepository;

    @Autowired
    public CabService(CabRepository cabRepository)
    {
        this.cabRepository = cabRepository;
    }


}
