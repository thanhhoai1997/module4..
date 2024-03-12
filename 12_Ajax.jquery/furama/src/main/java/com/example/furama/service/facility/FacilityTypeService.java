package com.example.furama.service.facility;

import com.example.furama.model.Facility;
import com.example.furama.model.FacilityType;
import com.example.furama.repositories.facility.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;


    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(Long facilityType) {
        return iFacilityTypeRepository.findById(facilityType).get();
    }


}
