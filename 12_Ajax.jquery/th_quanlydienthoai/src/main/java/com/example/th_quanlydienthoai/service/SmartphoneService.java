package com.example.th_quanlydienthoai.service;

import com.example.th_quanlydienthoai.model.Smartphone;
import com.example.th_quanlydienthoai.repositories.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return iSmartphoneRepository.findAll(pageable);
    }

    @Override
    public void save(Smartphone smartphone) {
        iSmartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone findById(Long id) {
        return iSmartphoneRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        iSmartphoneRepository.deleteById(id);
    }

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }
}
