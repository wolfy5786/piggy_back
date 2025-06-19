package com.piggyback.service;

import com.piggyback.dto.CustomerDTO;
import com.piggyback.mapper.CustomerMapper;
import com.piggyback.model.User;
import com.piggyback.repository.CustomerRepository;
import com.piggyback.model.Customer;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper)
    {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public boolean createCustomer(CustomerDTO customerDTO) {
        if (!customerRepository.findByUsername(customerDTO.getUsername()).isPresent())
        {
            customerRepository.save(customerMapper.newEntity(customerDTO));
            return true;
        }
        return false;
    }
    public boolean updateCustomer(@NotNull CustomerDTO customerDTO)
    {
        Optional<Customer> customer = customerRepository.findByUsername(customerDTO.getUsername());
        if(customer.isPresent())
        {
            customerRepository.save(customerMapper.updateEntity(customerDTO,customer.get()));
            return true;
        }
        return false;
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public boolean deleteCustomer(CustomerDTO customerDTO) {
        Optional<Customer> customer = customerRepository.findByUsername(customerDTO.getUsername());
        if (customer.isPresent())
        {
            customerRepository.delete(customer.get());
            return true;
        }
        return false;
    }

    public CustomerDTO getCustomerByUsername(String username)
    {
        Optional<Customer> customer = customerRepository.findByUsername(username);
        if(customer.isPresent())
        {
            return customerMapper.toDTO(customer.get());
        }
        return null; //return null?
    }

    public boolean customerExists(Integer userId) {
        return customerRepository.existsById(userId);
    }
}
