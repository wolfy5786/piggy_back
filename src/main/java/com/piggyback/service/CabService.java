package com.piggyback.service;

import com.piggyback.dto.CabDTO;
import com.piggyback.mapper.CabMapper;
import com.piggyback.model.Cab;
import com.piggyback.repository.CabRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CabService {
    private final CabRepository cabRepository;
    private final CabMapper cabMapper;

    @Autowired
    public CabService(CabRepository cabRepository, CabMapper cabMapper)
    {
        this.cabRepository = cabRepository;
        this.cabMapper = cabMapper;
    }

    public CabDTO getCabByLicensePlate(String LicensePlate){ //check for Null?
        return cabMapper.toDTO(cabRepository.findByLicensePlate(LicensePlate).get());
    }

    public List<CabDTO> getCabsByModel(String model){
        return cabRepository.findByModel(model).stream()
                .map(cabMapper::toDTO)                          //map to Dto
                .collect(Collectors.toList());
    }
    public boolean createCab(@NotNull CabDTO cabDTO) { //use exception handling
        if (!cabRepository.findByLicensePlate(cabDTO.getLicensePlate()).isPresent()) {
            cabRepository.save(cabMapper.newEntity(cabDTO));
            return true;
        }
        return false;
    }
    public boolean update(@NotNull CabDTO cabDTO)
    {
        Optional<Cab> cab = cabRepository.findByLicensePlate(cabDTO.getLicensePlate());
        if(cab.isPresent()) {
            cabRepository.save(cabMapper.updateEntity(cabDTO,cab.get()));
            return true;
        }
        return false;
    }

    public Iterable<Cab> getAllCabs() {
        return cabRepository.findAll();
    }

    public boolean deleteCab(@NotNull CabDTO cabDTO) {
        Optional<Cab> cab = cabRepository.findByLicensePlate(cabDTO.getLicensePlate());
        if(cab.isPresent()) {
            cabRepository.delete(cab.get());
            return true;
        }
        return false;
    }

}
