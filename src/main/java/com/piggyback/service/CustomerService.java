package com.piggyback.service;

import com.piggyback.model.User;
import com.piggyback.repository.CustomerRepository;
import com.piggyback.model.Customer;

import com.piggyback.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerById(Integer userId) {
        return customerRepository.findById(userId);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Integer userId) {
        customerRepository.deleteById(userId);
    }

    public boolean customerExists(Integer userId) {
        return customerRepository.existsById(userId);
    }
}
