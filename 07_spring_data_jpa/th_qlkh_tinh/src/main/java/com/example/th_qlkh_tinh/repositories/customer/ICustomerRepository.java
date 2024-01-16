package com.example.th_qlkh_tinh.repositories.customer;

import com.example.th_qlkh_tinh.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer as c where c.firstName like :firstname")
    Page<Customer> findAllByFirstNameContaining(@Param("firstname") String firstname, Pageable pageable);
}
