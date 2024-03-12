package com.example.furama.service.contract;

import com.example.furama.model.ContractDetail;
import com.example.furama.repositories.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll() ;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
