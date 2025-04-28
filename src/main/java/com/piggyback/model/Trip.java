package com.piggyback.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "trip")
public class Trip{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    Integer trip_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "user_id")
    Driver driver;

    @ManyToOne
    @JoinColumn(name="cab_id")
    Cab cab;

    @Column(name="fare")
    Float fare;

    @Column(name="tips")
    Float tips;

    @Column(name="driver_rating_given")
    Float driver_rating_given;

    @Column(name="customer_rating_given")
    Float customer_rating_given;

    @Enumerated(EnumType.STRING)
    @Column(name="trip_status")
    Trip_Status trip_status;

    @Column(name="date_time")
    LocalDateTime date_time;

    @Column(name="pickup")
    String pickup;

    @Column(name="destination")
    String destination;

    @Column(name="created_at")
    LocalDateTime created_at;

    @Column(name="updated_at")
    LocalDateTime updated_at;
}