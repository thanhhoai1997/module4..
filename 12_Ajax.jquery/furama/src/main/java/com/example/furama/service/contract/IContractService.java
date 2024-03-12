package com.example.furama.service.contract;

import com.example.furama.model.AttachFacility;
import com.example.furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Contract save(Contract contract);


    Contract findById(Long contractId);

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findAllByNameCustomer(Pageable pageable, String s);
}
