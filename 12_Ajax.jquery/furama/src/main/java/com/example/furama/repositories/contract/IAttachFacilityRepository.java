package com.example.furama.repositories.contract;

import com.example.furama.model.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Long> {
}
