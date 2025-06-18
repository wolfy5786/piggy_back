package com.piggyback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.parameters.P;

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

    public Cab() { //no args constructor for JPA repository
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
        //this.updatedAt = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        //this.updatedAt = LocalDateTime.now();
    }

    public Integer getCabId() {
        return cabId;
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

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Cab copyRecords(Cab cab){
        this.model = cab.model;
        return this;
    }
    public static class Builder
    {
        private Integer cabId;
        private String model;
        private String licensePlate;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        public Builder cabId(Integer cabId)
        {
            this.cabId = cabId;
            return this;
        }

        public Builder model(String model)
        {
            this.model = model;
            return this;
        }
        public Builder licensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
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
        public Cab build()
        {
            return new Cab(model,licensePlate);
        }
    }
}
