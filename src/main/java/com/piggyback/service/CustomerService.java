package com.piggyback.service;

import com.piggyback.repository.CustomerRepositary;
import com.piggyback.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class CustomerService {
    CustomerRepositary customerRepositary;

    @Autowired
    public CustomerService(CustomerRepositary customerRepositary)
    {
        this.customerRepositary = customerRepositary;
    }
}
