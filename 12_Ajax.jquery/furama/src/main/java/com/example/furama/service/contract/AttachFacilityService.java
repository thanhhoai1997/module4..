package com.example.furama.service.contract;

import com.example.furama.model.AttachFacility;
import com.example.furama.repositories.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements  IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll() ;
    }

    @Override
    public AttachFacility findById(Long attachFacilityId) {
        return iAttachFacilityRepository.findById(attachFacilityId).get();
    }
}
