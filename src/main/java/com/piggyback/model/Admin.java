package com.piggyback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "admin")
public class Admin extends User {

    public Admin(String name, String username, String password, String email, Long phone) {
        super(name, username, password, email, phone, Role.ADMIN);
    }

    public Admin(Builder builder)
    {
        super(builder);
        this.setRole(Role.ADMIN);
    }

    public Admin() { //no args constructor for JPA repository
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
