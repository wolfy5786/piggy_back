package com.piggyback.repository;

import com.piggyback.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {
    Optional <Cab> findByLicensePlate(String licensePlate);
    List<Cab> findByModel(String model);
}
