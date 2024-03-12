package com.example.furama.repositories.facility;

import com.example.furama.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Long> {
}
