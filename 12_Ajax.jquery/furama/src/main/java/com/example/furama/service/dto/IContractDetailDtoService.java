package com.example.furama.service.dto;

import com.example.furama.model.ContractDetailDTO;

import java.util.List;

public interface IContractDetailDtoService {
    void save(ContractDetailDTO contractDetailDTO);

    List<ContractDetailDTO> findAll();

    void deleteById(Long i);


}
