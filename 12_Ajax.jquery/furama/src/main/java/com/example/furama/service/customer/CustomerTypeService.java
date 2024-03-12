package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import com.example.furama.repositories.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long customerType) {
        return iCustomerTypeRepository.findById(customerType).get();
    }
}
