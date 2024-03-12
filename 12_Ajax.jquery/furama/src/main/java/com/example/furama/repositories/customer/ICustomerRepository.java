package com.example.furama.repositories.customer;

import com.example.furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer as c where c.name like :name")
    Page<Customer> findAllByName(Pageable pageable, @Param("name") String name);
}
