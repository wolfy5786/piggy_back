package com.piggyback.service;

import com.piggyback.dto.TripDTO;
import com.piggyback.mapper.TripMapper;
import com.piggyback.model.Trip;
import com.piggyback.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;


public class TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    @Autowired
    public TripService(TripRepository tripRepository, TripMapper tripMapper)
    {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    public Optional<Trip> getTripById(Integer tripId) {
        return tripRepository.findById(tripId);
    }

    public Iterable<TripDTO> getAllTrips() {
        return tripRepository.findAll().stream().map(tripMapper::toDTO).collect(Collectors.toList());
    }

    public boolean tripExists(Integer tripId) {
        return tripRepository.existsById(tripId);
    }



}
