package com.piggyback.repository;

import com.piggyback.model.Customer;
import com.piggyback.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
    Optional<Driver> findByUsername(String username);
    Optional<Driver> findByEmail(String email);
}
