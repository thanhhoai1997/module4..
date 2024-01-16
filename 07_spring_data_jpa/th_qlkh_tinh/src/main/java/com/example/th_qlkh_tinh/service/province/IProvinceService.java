package com.example.th_qlkh_tinh.service.province;

import com.example.th_qlkh_tinh.model.Province;
import com.example.th_qlkh_tinh.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProvinceService extends IGeneralService<Province> {
        Page<Province> findAll(Pageable pageable);
        Page<Province> findAllByNameContaining(String firstname, Pageable pageable);
}
