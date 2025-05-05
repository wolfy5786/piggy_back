package com.piggyback.repository;

import com.piggyback.model.Customer;
import com.piggyback.model.Driver;
import com.piggyback.model.Trip;
import com.piggyback.model.Trip_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByCustomer(Customer customer);
    List<Trip> findByDriver(Driver driver);
    List<Trip> findByStatus(Trip_Status status);

    @Query("SELECT t FROM Trip WHERE t.customer =: customer AND t.createdAt BETWEEN :start AND :end")
    List<Trip> findRecentByCustomer(@Param("customer")Customer customer,
                                    @Param("start") LocalDateTime start,
                                    @Param("end") LocalDateTime end);
    @Query("SELECT t FROM TRIP WHERE t.driver =: driver AND t.createdAt BETWEEN :start AND :end")
    List<Trip> findRecentByDriver(@Param("driver") Driver driver,
                                  @Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end);

}
