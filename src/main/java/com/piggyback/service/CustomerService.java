package com.piggyback.service;

import com.piggyback.model.User;
import com.piggyback.repository.CustomerRepository;
import com.piggyback.model.Customer;

import com.piggyback.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Customer createCustomer(Customer customer) {
        if (!customerRepository.findByUsername(customer.getUsername()).isPresent())
        {
            return customerRepository.save(customer);
        }
        return null;
    }
    public boolean updateCustomer(Customer customer)
    {
        if(customerRepository.findByUsername(customer.getUsername()).isPresent())
        {
            Customer new_record = customerRepository.findByUsername(customer.getUsername()).get().copy_records(customer);
            new_record.setUpdatedAt(LocalDateTime.now());
            customerRepository.save(new_record);
            return true;
        }
        return false;
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
