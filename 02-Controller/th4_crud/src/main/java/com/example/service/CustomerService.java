package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);
}
