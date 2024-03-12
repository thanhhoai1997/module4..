package com.example.furama.service.contract;

import com.example.furama.model.Contract;
import com.example.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
