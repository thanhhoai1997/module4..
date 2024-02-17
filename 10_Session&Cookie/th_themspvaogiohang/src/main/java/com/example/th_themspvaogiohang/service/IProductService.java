package com.example.th_themspvaogiohang.service;

import com.example.th_themspvaogiohang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    Page<Product> findAll(Pageable pageable);
}
