package com.piggyback.mapper;

import com.piggyback.dto.CabDTO;
import com.piggyback.model.Cab;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CabMapper {
    public Cab updateEntity(CabDTO cabDTO, Cab cab)
    {
        return new Cab.Builder()
                .model(cabDTO.getModel()) //from client
                .licensePlate(cab.getLicensePlate())
                .cabId(cab.getCabId()) //from Entity
                .createdAt(cab.getCreatedAt())
                .updatedAt(LocalDateTime.now()) //updated now
                .build();
    }
    public CabDTO toDTO(Cab cab)
    {
        CabDTO.Builder builder = new CabDTO.Builder();
        return builder.model(cab.getModel())
                .licensePlate(cab.getLicensePlate())
                .build();

    }
    public Cab newEntity(CabDTO cabDTO)
    {
        return new Cab.Builder()
                .model(cabDTO.getModel())
                .licensePlate(cabDTO.getLicensePlate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build(); //id assigned by DB
    }


}
