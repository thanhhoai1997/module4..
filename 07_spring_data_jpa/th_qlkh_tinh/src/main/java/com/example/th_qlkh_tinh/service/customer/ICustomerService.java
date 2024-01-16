package com.example.th_qlkh_tinh.service.customer;

import com.example.th_qlkh_tinh.model.Customer;
import com.example.th_qlkh_tinh.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname,Pageable pageable);

}
