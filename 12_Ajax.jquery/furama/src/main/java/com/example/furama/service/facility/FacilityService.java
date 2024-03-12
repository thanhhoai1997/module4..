package com.example.furama.service.facility;

import com.example.furama.model.Facility;
import com.example.furama.repositories.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(Long id) {
        return iFacilityRepository.findById(id).get();
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Facility> findAllByName(Pageable pageable, String s) {
        return iFacilityRepository.findAllByName(pageable,"%" + s + "%");
    }
}
