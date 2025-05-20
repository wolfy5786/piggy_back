package com.piggyback.repository;

import com.piggyback.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByCustomer(Customer customer);
    List<Trip> findByDriver(Driver driver);
    List<Trip> findByStatus(Trip_Status status);

    @Query("SELECT t FROM Trip t WHERE t.customer = :customer AND t.createdAt BETWEEN :start AND :end")
    List<Trip> findRecentByCustomer(@Param("customer")Customer customer,
                                    @Param("start") LocalDateTime start,
                                    @Param("end") LocalDateTime end);
    @Query("SELECT t FROM Trip t WHERE t.driver = :driver AND t.createdAt BETWEEN :start AND :end")
    List<Trip> findRecentByDriver(@Param("driver") Driver driver,
                                  @Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end);

    @Query("SELECT t FROM Trip t WHERE t.cab = :cab AND t.createdAt BETWEEN :start AND :end")
    List<Trip> findRecentByCab(@Param("cab")Cab cab,
                               @Param("start") LocalDateTime start,
                               @Param("end") LocalDateTime end);

    @Query("SELECT t FROM Trip t WHERE t.createdAt > :start")
    List<Trip> findRecentByCustomer(@Param("customer")Customer customer,
                                    @Param("start") LocalDateTime start);


    @Query("SELECT t FROM Trip t WHERE t.customer = :customer ORDER BY t.updatedAt DESC LIMIT 1")
    Optional<Trip> findRecentByCustomer(@Param("customer")Customer customer);

    @Query("SELECT t FROM Trip t WHERE t.driver = :driver ORDER BY t.updatedAt DESC LIMIT 1")
    Optional<Trip> findRecentByDriver(@Param("driver")Driver driver);

    @Query("SELECT t FROM Trip t WHERE t.cab = :cab ORDER BY t.updatedAt DESC LIMIT 1")
    Optional<Cab> findRecentByCab(@Param("cab")Cab cab);

}
