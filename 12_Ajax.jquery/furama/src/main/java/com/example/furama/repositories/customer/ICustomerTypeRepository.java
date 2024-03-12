package com.example.furama.repositories.customer;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
