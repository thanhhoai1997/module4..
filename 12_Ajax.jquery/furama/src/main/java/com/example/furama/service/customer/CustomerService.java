package com.example.furama.service.customer;

import com.example.furama.model.Customer;
import com.example.furama.repositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String name) {
        return iCustomerRepository.findAllByName(pageable,"%" + name + "%");
    }
}
