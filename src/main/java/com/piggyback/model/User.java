package com.piggyback.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User{
    @Column(name = "name")
    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer user_id;

    @Column(name="phone")
    Long phone;

    @Column(name="username", nullable = false)
    String username;

    @Column(name="password", nullable = false)
    String password;

    @Column(name="email")
    String email;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    Role role;

    @Column(name="created_at")
    LocalDateTime created_at;

    @Column(name="updated_at")
    LocalDateTime updated_at;
}