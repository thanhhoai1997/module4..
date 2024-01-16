package com.example.th_qlkh_tinh.service.customer;

import com.example.th_qlkh_tinh.model.Customer;
import com.example.th_qlkh_tinh.repositories.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();

    }

    @Override
    public Optional findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);

    }

    @Override
    public void remote(Long id) {
        iCustomerRepository.deleteById(id);
    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return iCustomerRepository.findAllByFirstNameContaining("%"+firstname+"%",pageable);
    }
}
