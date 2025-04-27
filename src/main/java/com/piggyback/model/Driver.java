package com.piggyback.model;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver{

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    User user;

    @Column(name="user_id")
    Integer user_id;

    @Column(name="assigned_cab_id")
    Integer assignedCabId;

    @Column(name="driver_rating")
    Float driver_rating;

    @Enumerated(EnumType.STRING)
    @Column(name="driver_status")
    Driver_Status driver_status;

}