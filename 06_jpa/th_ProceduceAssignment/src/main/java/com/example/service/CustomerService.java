package com.example.service;

import com.example.model.Customer;
import com.example.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return iCustomerRepository.insertWithStoredProcedure(customer);
    }
}
