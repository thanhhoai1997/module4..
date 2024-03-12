package com.example.thi_module.repositories;

import com.example.thi_module.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
