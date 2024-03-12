package com.example.furama.service.dto;

import com.example.furama.model.ContractDetailDTO;
import com.example.furama.repositories.contract.IContractDetailRepository;
import com.example.furama.repositories.dto.IContractDetailDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailDtoService implements IContractDetailDtoService{
    @Autowired
    private IContractDetailDtoRepository iContractDetailDtoRepository;
    @Override
    public void save(ContractDetailDTO contractDetailDTO) {
        iContractDetailDtoRepository.save(contractDetailDTO);
    }

    @Override
    public List<ContractDetailDTO> findAll() {
        return iContractDetailDtoRepository.findAll();
    }





    @Override
    public void deleteById(Long i) {
        iContractDetailDtoRepository.deleteById(i);
    }


}
