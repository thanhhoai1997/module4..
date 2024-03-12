package com.example.th_quanlydienthoai.repositories;

import com.example.th_quanlydienthoai.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
