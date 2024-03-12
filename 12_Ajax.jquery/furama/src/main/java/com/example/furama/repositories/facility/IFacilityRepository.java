package com.example.furama.repositories.facility;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility,Long> {
    @Query("select f from Facility as f where f.name like :name")
    Page<Facility> findAllByName(Pageable pageable,@Param("name") String s);
}
