package com.piggyback.repository;

import com.piggyback.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepositary extends JpaRepository<Trip, Integer> {

}
