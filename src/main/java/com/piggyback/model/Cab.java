package com.piggyback.model;


import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "cab")
public class Cab{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cab_id")
    Integer cab_id;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "user_id")
    Driver driver;

    @Column(name="model")
    String model;

    @Column(name="license_plate")
    String license_plate;

    @Column(name="created_at")
    LocalDateTime created_at;

    @Column(name="updated_at")
    LocalDateTime updated_at;
}