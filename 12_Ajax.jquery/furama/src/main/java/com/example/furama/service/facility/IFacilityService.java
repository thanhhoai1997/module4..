package com.example.furama.service.facility;

import com.example.furama.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    void  save(Facility facility);

    Page<Facility> findAll(Pageable pageable);

    void deleteById(Long id);

    Facility findById(Long id);
    List<Facility> findAll();

    Page<Facility> findAllByName(Pageable pageable, String s);
}
