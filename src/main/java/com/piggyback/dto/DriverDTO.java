package com.piggyback.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.piggyback.model.Driver_Status;
import com.piggyback.model.Role;

public class DriverDTO extends UserDTO{
    private Double driverRating;
    private Driver_Status driverStatus;

    @JsonCreator
    public DriverDTO(@JsonProperty("name") String name,
                     @JsonProperty("username") String username,
                     @JsonProperty("password") String password,
                     @JsonProperty("email") String email,
                     @JsonProperty("phone") Long phone,
                     @JsonProperty("role") Role role,
                     @JsonProperty("driverRating") Double driverRating,
                     @JsonProperty("driverStatus") Driver_Status driverStatus) {
        super(name, username, password, email, phone, role);
        this.driverRating = driverRating;
        this.driverStatus = driverStatus;
    }

    public DriverDTO(Builder builder) {
        super(builder);
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
