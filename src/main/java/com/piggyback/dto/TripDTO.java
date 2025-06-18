package com.piggyback.dto;

public class TripDTO {
    public Integer tripId; //only id being shared to the frontend
    private CustomerDTO customerDTO;
    private DriverDTO driverDTO;
    private CabDTO cabDTO;
    private Double fare;
    private String source;
    private String destination;

    public TripDTO(Integer tripId, CustomerDTO customerDTO, DriverDTO driverDTO, CabDTO cabDTO, Double fare, String source, String destination) {
        this.tripId = tripId;
        this.customerDTO = customerDTO;
        this.driverDTO = driverDTO;
        this.cabDTO = cabDTO;
        this.fare = fare;
        this.source = source;
        this.destination = destination;
    }

    public TripDTO(CustomerDTO customerDTO, DriverDTO driverDTO, CabDTO cabDTO, Double fare, String source, String destination) {
        this.customerDTO = customerDTO;
        this.driverDTO = driverDTO;
        this.cabDTO = cabDTO;
        this.fare = fare;
        this.source = source;
        this.destination = destination;
    }

    public TripDTO() {
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public DriverDTO getDriverDTO() {
        return driverDTO;
    }

    public void setDriverDTO(DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public CabDTO getCabDTO() {
        return cabDTO;
    }

    public void setCabDTO(CabDTO cabDTO) {
        this.cabDTO = cabDTO;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "tripId=" + tripId +
                ", customerDTO=" + customerDTO +
                ", driverDTO=" + driverDTO +
                ", cabDTO=" + cabDTO +
                ", fare=" + fare +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public static class Builder{
        public Integer tripId;
        private CustomerDTO customerDTO;
        private DriverDTO driverDTO;
        private CabDTO cabDTO;
        private Double fare;
        private String source;
        private String destination;
        public Builder tripId(Integer tripId)
        {
            this.tripId = tripId;
            return this;
        }
        public Builder customerDTO(CustomerDTO customerDTO)
        {
            this.customerDTO = customerDTO;
            return this;
        }
        public Builder driverDTO(DriverDTO driverDTO)
        {
            this.driverDTO = driverDTO;
            return this;
        }
        public Builder cabDTO(CabDTO cabDTO)
        {
            this.cabDTO = cabDTO;
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
        public Builder destination(String destination)
        {
            this.destination = destination;
            return this;
        }
        public TripDTO build()
        {
            TripDTO tripDTO = new TripDTO(tripId,customerDTO,driverDTO,cabDTO,fare,source,destination);
            return tripDTO;
        }
    }
}
