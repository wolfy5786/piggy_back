package com.piggyback.mapper;

import com.piggyback.dto.TripDTO;
import com.piggyback.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    CustomerMapper customerMapper;
    DriverMapper driverMapper;
    CabMapper cabMapper;

    @Autowired
    public TripMapper(CustomerMapper customerMapper, DriverMapper driverMapper, CabMapper cabMapper)
    {
        this.customerMapper = customerMapper;
        this.driverMapper = driverMapper;
        this.cabMapper = cabMapper;
    }
    public TripDTO toDTO(Trip trip)
    {
        return new TripDTO.Builder()
                .tripId(trip.getTripId())
                .customerDTO(customerMapper.toDTO(trip.getCustomer()))
                .driverDTO(driverMapper.toDTO(trip.getDriver()))
                .cabDTO(cabMapper.toDTO(trip.getCab()))
                .fare(trip.getFare())
                .source(trip.getSource())
                .destination(trip.getDestination())
                .tripStatus(trip.getStatus())
                .build();

    }
}
