package com.piggyback.dto;

import com.piggyback.model.Driver_Status;
import com.piggyback.model.Role;

public class DriverDTO extends UserDTO{
    private Double driverRating;
    private Driver_Status driverStatus;

    public DriverDTO(String name, String username, String password, String email, Long phone, Role role, Double driverRating, Driver_Status driverStatus) {
        super(name, username, password, email, phone, role);
        this.driverRating = driverRating;
        this.driverStatus = driverStatus;
    }

    public DriverDTO(String name, String username, String password, String email, Long phone, Role role) {
        super(name, username, password, email, phone, role);
    }

    public DriverDTO(Builder builder) {
        super(builder);
    }

    public DriverDTO() {
    }

    public Double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(Double driverRating) {
        this.driverRating = driverRating;
    }

    public Driver_Status getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(Driver_Status driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "driverRating=" + driverRating +
                ", driverStatus=" + driverStatus +
                '}';
    }

    public static class Builder extends UserDTO.Builder<Builder>
    {
        private Double driverRating;
        private Driver_Status driverStatus;

        public Builder driverRating(Double driverRating)
        {
            this.driverRating = driverRating;
            return this;
        }

        public Builder driverStatus(Driver_Status driverStatus)
        {
            this.driverStatus = driverStatus;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public DriverDTO build() {
            return new DriverDTO(this);
        }
    }
}
