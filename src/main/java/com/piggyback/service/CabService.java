package com.piggyback.service;

import com.piggyback.model.Cab;
import com.piggyback.repository.CabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class CabService {
    private final CabRepository cabRepository;

    @Autowired
    public CabService(CabRepository cabRepository)
    {
        this.cabRepository = cabRepository;
    }
    public Cab saveCab(Cab cab) {
        return cabRepository.save(cab);
    }

    public Optional<Cab> getCabById(Integer cabId) {
        return cabRepository.findById(cabId);
    }

    public Iterable<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    public void deleteCab(Integer cabId) {
        cabRepository.deleteById(cabId);
    }

    public boolean cabExists(Integer cabId) {
        return cabRepository.existsById(cabId);
    }


}
