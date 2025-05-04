package com.piggyback.service;

import com.piggyback.model.Trip;
import com.piggyback.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository)
    {
        this.tripRepository = tripRepository;
    }
    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Optional<Trip> getTripById(Integer tripId) {
        return tripRepository.findById(tripId);
    }

    public Iterable<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public void deleteTrip(Integer tripId) {
        tripRepository.deleteById(tripId);
    }

    public boolean tripExists(Integer tripId) {
        return tripRepository.existsById(tripId);
    }

}
