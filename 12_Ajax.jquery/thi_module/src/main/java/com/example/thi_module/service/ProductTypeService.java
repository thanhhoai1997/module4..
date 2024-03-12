package com.example.thi_module.service;

import com.example.thi_module.model.ProductType;
import com.example.thi_module.repositories.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Long productType) {
        return iProductTypeRepository.findById(productType).get();
    }
}
