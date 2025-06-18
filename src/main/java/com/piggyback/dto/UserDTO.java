package com.piggyback.dto;

import com.piggyback.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public abstract class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    private String password;
    @Email
    private String email;
    private Long phone;
    private Role role;

    public UserDTO(String name, String username, String password, String email, Long phone, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
    protected UserDTO(Builder<?> builder) {
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
    }
    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", role=" + role +
                '}';
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String name;
        private String username;
        private String password;
        private String email;
        private Long phone;
        private Role role;

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T username(String username) {
            this.username = username;
            return self();
        }

        public T password(String password) {
            this.password = password;
            return self();
        }

        public T email(String email) {
            this.email = email;
            return self();
        }

        public T phone(Long phone) {
            this.phone = phone;
            return self();
        }

        public T role(Role role) {
            this.role = role;
            return self();
        }

        protected abstract T self();

        public abstract UserDTO build();
    }

}
