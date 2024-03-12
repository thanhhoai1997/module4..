package com.example.furama.service.contract;

import com.example.furama.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(Long attachFacilityId);
}
