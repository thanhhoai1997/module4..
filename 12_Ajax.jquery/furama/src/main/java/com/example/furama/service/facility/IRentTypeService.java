package com.example.furama.service.facility;

import com.example.furama.model.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    RentType findById(Long rentType);
}
