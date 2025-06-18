package com.piggyback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer extends User {

    private Double customerRating;

    @JsonCreator
    public Customer(@JsonProperty("name") String name,
                    @JsonProperty("username") String username,
                    @JsonProperty("password") String password,
                    @JsonProperty("email") String email,
                    @JsonProperty("phone") Long phone)
    {
        super(name, username, password, email, phone, Role.CUSTOMER);
    }

    public Customer(Builder builder) {
        super(builder);
        this.customerRating = builder.customerRating;
    }

    public Double getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(Double customerRating) {
        this.customerRating = customerRating;
        //this.setUpdatedAt(LocalDateTime.now());
    }

    public Customer copy_records(Customer customer)
    {
        this.setEmail(customer.getEmail());
        this.setName(customer.getName());
        this.setPassword(customer.getPassword());
        this.setPhone(customer.getPhone());
        return this;
    }
    public static class Builder extends User.Builder<Builder>
    {
        Double customerRating;
        public Builder customerRating(Double customerRating)
        {
            this.customerRating = customerRating;
            return this;
        }
        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Customer build() {
            return new Customer(this);
        }
    }
}
