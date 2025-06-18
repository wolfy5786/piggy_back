package com.piggyback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "driver")
public class Driver extends User {

    private Double driverRating;

    @Enumerated(EnumType.STRING)
    private Driver_Status driverStatus;

    @JsonCreator
    public Driver(@JsonProperty("name") String name,
                  @JsonProperty("username") String username,
                  @JsonProperty("password") String password,
                  @JsonProperty("email") String email,
                  @JsonProperty("phone") Long phone)
    {
        super(name, username, password, email, phone, Role.DRIVER);
        this.driverStatus = Driver_Status.AWAY;
    }

    public Driver(Builder builder) {
        super(builder);
        this.driverStatus = builder.driverStatus;
        this.driverRating = builder.driverRating;
    }

    public Double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Double driverRating) {
        this.driverRating = driverRating;
        this.setUpdatedAt(LocalDateTime.now());
    }

    public Driver_Status getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Driver_Status driverStatus) {
        this.driverStatus = driverStatus;
        //this.setUpdatedAt(LocalDateTime.now());
    }


    public Driver copy_records(Driver driver)
    {
        this.setEmail(driver.getEmail());
        this.setName(driver.getName());
        this.setPassword(driver.getPassword());
        this.setPhone(driver.getPhone());
        return this;
    }

    public static class Builder extends User.Builder<Builder>{
        Driver_Status driverStatus;
        Double driverRating;

        public Builder driverStatus(Driver_Status driverStatus)
        {
            this.driverStatus = driverStatus;
            return this;
        }
        public Builder driverRating(Double driverRating)
        {
            this.driverRating = driverRating;
            return this;
        }
        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Driver build() {
            return new Driver(this);
        }
    }
}
