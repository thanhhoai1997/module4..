package com.example.furama.service.facility;

import com.example.furama.model.RentType;
import com.example.furama.repositories.facility.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<com.example.furama.model.RentType> findAll() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long rentType) {
        return iRentTypeRepository.findById(rentType).get();
    }
}
