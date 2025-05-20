package com.piggyback.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;

    private Double fare;

    private String source;
    private String destination;

    @Enumerated(EnumType.STRING)
    private Trip_Status status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Trip(Customer customer, Driver driver, double fare, String source, String destination)
    {
        this.customer = customer;
        this.driver= driver;
        this.fare = fare;
        this.source = source;
        this.destination = destination;
        this.status = Trip_Status.ONGOING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
        //this.setUpdatedAt(LocalDateTime.now());
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
        //this.setUpdatedAt(LocalDateTime.now());
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
        //this.setUpdatedAt(LocalDateTime.now());
    }

    public Trip_Status getStatus() {
        return status;
    }

    public void setStatus(Trip_Status status) {
        this.status = status;
        //this.setUpdatedAt(LocalDateTime.now());
    }

    public Integer getTripId() {
        return tripId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
