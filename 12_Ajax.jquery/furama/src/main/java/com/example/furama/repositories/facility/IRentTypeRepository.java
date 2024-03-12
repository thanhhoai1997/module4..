package com.example.furama.repositories.facility;

import com.example.furama.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
}
