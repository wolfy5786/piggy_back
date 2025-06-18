package com.piggyback.dto;

import com.piggyback.model.Role;

public class CustomerDTO extends UserDTO{
    private Double customerRating;

    public CustomerDTO(String name, String username, String password, String email, Long phone, Role role, Double customerRating) {
        super(name, username, password, email, phone, role);
        this.customerRating = customerRating;
    }

    public CustomerDTO(String name, String username, String password, String email, Long phone, Role role) {
        super(name, username, password, email, phone, role);
    }

    private CustomerDTO(Builder builder) {
        super(builder);
        this.customerRating = builder.customerRating;
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
