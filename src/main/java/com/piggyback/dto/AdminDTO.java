package com.piggyback.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.piggyback.model.Role;

public class AdminDTO extends UserDTO{

    @JsonCreator
    public AdminDTO(@JsonProperty("name") String name,
                    @JsonProperty("username") String username,
                    @JsonProperty("password") String password,
                    @JsonProperty("email") String email,
                    @JsonProperty("phone") Long phone) {
        super(name, username, password, email, phone, Role.ADMIN);
    }

    public AdminDTO(Builder builder) {
        super(builder);
        this.setRole(Role.ADMIN);
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
