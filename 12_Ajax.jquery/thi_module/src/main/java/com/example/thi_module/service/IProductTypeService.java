package com.example.thi_module.service;

import com.example.thi_module.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();

    ProductType findById(Long productType);
}
