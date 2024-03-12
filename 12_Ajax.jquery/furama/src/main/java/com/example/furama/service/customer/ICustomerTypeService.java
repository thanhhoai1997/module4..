package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Long customerType);
}
