package com.piggyback.model;

import jakarta.persistence.*;

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

    public Trip() {
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

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", customer=" + customer +
                ", driver=" + driver +
                ", cab=" + cab +
                ", fare=" + fare +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static class Builder{
        public Integer tripId; //only id being shared to the frontend
        private Customer customer;
        private Driver driver;
        private Cab cab;
        private Double fare;
        private String source;
        private String destination;
        private Trip_Status trip_status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        public Builder tripId(Integer tripId)
        {
            this.tripId = tripId;
            return this;
        }
        public Builder customer(Customer customer)
        {
            this.customer = customer;
            return this;
        }
        public Builder driver(Driver driver)
        {
            this.driver = driver;
            return this;
        }
        public Builder cab(Cab cab)
        {
            this.cab = cab;
            return this;
        }
        public Builder fare(Double fare)
        {
            this.fare = fare;
            return this;
        }
        public Builder source(String source)
        {
            this.source = source;
            return this;
        }
        public Builder tripStatus(Trip_Status trip_status)
        {
            this.trip_status = trip_status;
            return this;
        }
        public Builder createdAt(LocalDateTime createdAt)
        {
            this.createdAt = createdAt;
            return this;
        }
        public Builder updatedAt(LocalDateTime updatedAt)
        {
            this.updatedAt = updatedAt;
            return this;
        }
    }
}
