package com.piggyback.dto;

public class CabDTO {
    private String model;
    private String licensePlate;

    public CabDTO(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "CabDTO{" +
                "model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
    public static class Builder
    {
        private String model;
        private String licensePlate;

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
        public CabDTO build()
        {
            CabDTO cabDTO = new CabDTO(model,licensePlate);
            return cabDTO;
        }
    }
}
