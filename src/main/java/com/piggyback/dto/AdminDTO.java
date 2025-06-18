package com.piggyback.dto;

import com.piggyback.model.Role;

public class AdminDTO extends UserDTO{

    public AdminDTO(String name, String username, String password, String email, Long phone, Role role) {
        super(name, username, password, email, phone, role);
    }

    public AdminDTO(Builder builder) {
        super(builder);
    }

    public AdminDTO() {
    }

    public static class Builder extends UserDTO.Builder<Builder>{

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public AdminDTO build() {
            return new AdminDTO(this);
        }
    }
}
