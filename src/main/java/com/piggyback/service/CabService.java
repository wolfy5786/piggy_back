package com.piggyback.service;

import com.piggyback.model.Cab;
import com.piggyback.repository.CabRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CabService {
    private final CabRepository cabRepository;

    @Autowired
    public CabService(CabRepository cabRepository)
    {
        this.cabRepository = cabRepository;
    }
    public Cab getCabById(int Id){return cabRepository.findById(Id).get();}

    public Cab getCabByLicensePlate(String LicensePlate){ return cabRepository.findByLicensePlate(LicensePlate).get();}

    public List<Cab> getCabsByModel(String model){return cabRepository.findByModel(model);}
    public Cab createCab(@NotNull Cab cab) {
        if (!cabRepository.findByLicensePlate(cab.getLicensePlate()).isPresent()) {
            return cabRepository.save(cab);
        }
        return null;
    }
    public boolean update(@NotNull Cab cab)
    {
        if(cabRepository.findByLicensePlate(cab.getLicensePlate()).isPresent()) {
            Cab updatedRecord = cabRepository.findByLicensePlate(cab.getLicensePlate()).get().copyRecords(cab);
            updatedRecord.setUpdatedAt(LocalDateTime.now());
            cabRepository.save(updatedRecord);
            return true;
        }
        return false;
    }

    public Iterable<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    public boolean deleteCab(@NotNull Cab cab) {
        if(cabRepository.findByLicensePlate(cab.getLicensePlate()).isPresent()) {
            cabRepository.delete(cabRepository.findByLicensePlate(cab.getLicensePlate()).get());
            return true;
        }
        return false;
    }

}
