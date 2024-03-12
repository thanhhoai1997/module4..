package com.example.furama.repositories.contract;

import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query("select c from Contract as c where c.customer.name like :name ")
    Page<Contract> findALlByCustomerName(Pageable pageable,@Param("name") String s);
}
