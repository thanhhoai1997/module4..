package com.example.th_themspvaogiohang.service;

import com.example.th_themspvaogiohang.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
