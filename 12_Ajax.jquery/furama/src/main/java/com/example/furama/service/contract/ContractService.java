package com.example.furama.service.contract;

import com.example.furama.model.AttachFacility;
import com.example.furama.model.Contract;
import com.example.furama.repositories.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Contract save(Contract contract) {
      return   iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Long contractId) {
        return iContractRepository.findById(contractId).get();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByNameCustomer(Pageable pageable, String s) {
        return iContractRepository.findALlByCustomerName(pageable,"%"+s+"%");
    }


}
