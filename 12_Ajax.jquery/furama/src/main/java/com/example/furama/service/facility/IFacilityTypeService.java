package com.example.furama.service.facility;

import com.example.furama.model.Facility;
import com.example.furama.model.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();


    FacilityType findById(Long facilityType);
}
