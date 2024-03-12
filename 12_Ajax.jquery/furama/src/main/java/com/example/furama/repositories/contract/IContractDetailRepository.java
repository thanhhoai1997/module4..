package com.example.furama.repositories.contract;

import com.example.furama.model.ContractDetail;
import com.example.furama.model.ContractDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
}
