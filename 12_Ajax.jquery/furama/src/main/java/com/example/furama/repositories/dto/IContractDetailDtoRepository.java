package com.example.furama.repositories.dto;

import com.example.furama.model.ContractDetail;
import com.example.furama.model.ContractDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IContractDetailDtoRepository extends JpaRepository<ContractDetailDTO,Long> {

}
