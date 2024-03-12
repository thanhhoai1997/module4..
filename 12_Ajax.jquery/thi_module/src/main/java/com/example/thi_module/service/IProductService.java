package com.example.thi_module.service;

import com.example.thi_module.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Product findById(Long id);
    void deleteById(Long id);

    Page<Product> findByName(Pageable pageable, String name);

    

    Page<Product> findByProductType(Pageable pageable, String s);

    Page<Product> findByProduct(Pageable pageable, String s);
}
