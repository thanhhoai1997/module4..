package com.example.th_qlkh_tinh.service.province;

import com.example.th_qlkh_tinh.model.Province;
import com.example.th_qlkh_tinh.repositories.province.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private IProvinceRepository iProvinceRepository;
    @Override
    public Iterable<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);

    }

    @Override
    public void remote(Long id) {
        iProvinceRepository.findById(id);

    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return iProvinceRepository.findAll(pageable);
    }

    @Override
    public Page<Province> findAllByNameContaining(String firstname, Pageable pageable) {
        return iProvinceRepository.findAllByNameContaining(firstname,pageable);
    }
}
