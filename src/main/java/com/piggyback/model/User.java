package com.piggyback.model;

import com.piggyback.dto.UserDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    private String username;
    private String password;
    private String email;
    private Long phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public User() //no args constructor for JPA repository
    {
    }

    public User(String name,
                String username,
                String password,
                String email,
                Long phone, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    protected User(User.Builder<?> builder) {
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.role = builder.role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    public static abstract class Builder<T extends Builder<T>>
    {
        private Integer userId;
        private String name;
        private String username;
        private String password;
        private String email;
        private Long phone;
        private Role role;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public T userId(Integer userId)
        {
            this.userId = userId;
            return self();
        }

        public T name(String name)
        {
            this.name = name;
            return self();
        }
        public T username(String username)
        {
            this.username = username;
            return self();
        }
        public T password(String password)
        {
            this.password = password;
            return self();
        }
        public T email(String email)
        {
            this.email = email;
            return self();
        }
        public T phone(Long phone)
        {
            this.phone = phone;
            return self();
        }
        public T role(Role role)
        {
            this.role = role;
            return self();
        }
        public T createdAt(LocalDateTime createdAt)
        {
            this.createdAt = createdAt;
            return self();
        }
        public T updatedAt(LocalDateTime updatedAt)
        {
            this.updatedAt = updatedAt;
            return self();
        }
        public abstract T self();
        public abstract User build();
    }
}
