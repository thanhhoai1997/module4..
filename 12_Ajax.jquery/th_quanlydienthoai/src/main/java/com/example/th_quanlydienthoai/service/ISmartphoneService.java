package com.example.th_quanlydienthoai.service;

import com.example.th_quanlydienthoai.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);
    void save (Smartphone smartphone);
    Smartphone findById(Long id);
    void deleteById(Long id);
    List<Smartphone> findAll();
}
