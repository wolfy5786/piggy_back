package com.piggyback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cabId;

    private String model;
    private String licensePlate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonCreator
    public Cab(@JsonProperty("model") String model,
               @JsonProperty("licensePlate") String licensePlate)
    {
        this.model = model;
        this.licensePlate = licensePlate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
        this.updatedAt = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        this.updatedAt = LocalDateTime.now();
    }
}
