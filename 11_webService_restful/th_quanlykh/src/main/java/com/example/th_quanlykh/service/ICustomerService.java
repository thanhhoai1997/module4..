package com.example.th_quanlykh.service;

import com.example.th_quanlykh.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(Customer customer);
    void remove(Long id);
}
