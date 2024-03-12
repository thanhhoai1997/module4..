package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    void save(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    void deleteById(Long id);

    Customer findById(Long id);
    List<Customer> findAll();

    Page<Customer> findAllByName(Pageable pageable, String name);
}
