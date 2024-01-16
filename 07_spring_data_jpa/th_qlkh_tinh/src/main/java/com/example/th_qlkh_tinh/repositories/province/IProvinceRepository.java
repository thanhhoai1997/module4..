package com.example.th_qlkh_tinh.repositories.province;

import com.example.th_qlkh_tinh.model.Customer;
import com.example.th_qlkh_tinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province,Long> {
    Page<Province> findAllByNameContaining(String firstname, Pageable pageable);
}
