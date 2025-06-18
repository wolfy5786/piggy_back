package com.piggyback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "admin")
public class Admin extends User {

    @JsonCreator
    public Admin(@JsonProperty("name") String name,
                 @JsonProperty("username") String username,
                 @JsonProperty("password") String password,
                 @JsonProperty("email") String email,
                 @JsonProperty("phone") Long phone) {
        super(name, username, password, email, phone, Role.ADMIN);
    }

    public Admin(Builder builder)
    {
        super(builder);
    }
    public Admin copy_records(Admin admin)
    {
        this.setEmail(admin.getEmail());
        this.setName(admin.getName());
        this.setPassword(admin.getPassword());
        this.setPhone(admin.getPhone());
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Builder extends User.Builder<Builder>
    {

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public Admin build() {
            return new Admin(this);
        }
    }
}
