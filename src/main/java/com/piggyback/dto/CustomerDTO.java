package com.piggyback.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.piggyback.model.Role;

public class CustomerDTO extends UserDTO{
    private Double customerRating;

    @JsonCreator
    public CustomerDTO(@JsonProperty("name") String name,
                       @JsonProperty("username") String username,
                       @JsonProperty("password") String password,
                       @JsonProperty("email") String email,
                       @JsonProperty("phone") Long phone,
                       @JsonProperty("customerRating") Double customerRating) {
        super(name, username, password, email, phone, Role.CUSTOMER);
        this.customerRating = customerRating;
    }

    private CustomerDTO(Builder builder) {
        super(builder);
        this.customerRating = builder.customerRating;
        this.setRole(Role.CUSTOMER);
    }

    public CustomerDTO() {
    }

    public Double getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(Double customerRating) {
        this.customerRating = customerRating;
    }
    public static class Builder extends UserDTO.Builder<Builder> {
        private Double customerRating;

        public Builder customerRating(Double customerRating) {
            this.customerRating = customerRating;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public CustomerDTO build() {
            return new CustomerDTO(this);
        }
    }

}
