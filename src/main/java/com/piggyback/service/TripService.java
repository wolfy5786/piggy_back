package com.piggyback.service;

import com.piggyback.model.Trip;
import com.piggyback.repository.TripRepositary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TripService {
    private final TripRepositary tripRepositary;

    @Autowired
    public TripService(TripRepositary tripRepositary)
    {
        this.tripRepositary = tripRepositary;
    }
}
