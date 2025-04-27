package com.piggyback.model;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer
{
    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    User user;

    @Id
    @Column(name = "user_id")
    Integer user_id;

    @Column(name="customer_rating")
    Float customer_rating;
}