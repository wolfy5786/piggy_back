package com.piggyback.mapper;

import com.piggyback.dto.CustomerDTO;
import com.piggyback.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {
    public Customer newEntity(CustomerDTO customerDTO)
    {
        return new Customer.Builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .username(customerDTO.getUsername())
                .password(customerDTO.getPassword())
                .customerRating(customerDTO.getCustomerRating())
                .phone(customerDTO.getPhone())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build(); //no id
    }
    public Customer updateEntity(CustomerDTO customerDTO, Customer customer)
    {
        return new Customer.Builder()
                .name(customerDTO.getName()) //from client
                .username(customerDTO.getUsername())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .phone(customerDTO.getPhone())//from client*
                .createdAt(customer.getCreatedAt()) //from DB
                .updatedAt(LocalDateTime.now()) //updated now
                .userId(customer.getUserId()) //from DB
                .build();
    }
    public CustomerDTO toDTO(Customer customer)
    {
        CustomerDTO.Builder builder = new CustomerDTO.Builder();
        return builder.name(customer.getName())
                .email(customer.getEmail())
                .username(customer.getUsername())
                .customerRating(customer.getCustomerRating())
                .password(customer.getPassword())
                .phone(customer.getPhone())
                .build();
    }
}
