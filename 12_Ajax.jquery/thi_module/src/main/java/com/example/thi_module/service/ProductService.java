package com.example.thi_module.service;

import com.example.thi_module.model.Product;
import com.example.thi_module.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void save(Product a) {
        iProductRepository.save(a);

    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);

    }

    @Override
    public Page<Product> findByName(Pageable pageable, String name) {
        return iProductRepository.findByName(pageable,"%"+name+"%");
    }



    @Override
    public Page<Product> findByProductType(Pageable pageable, String price) {
        return iProductRepository.findByProductType(pageable,price);
    }

    @Override
    public Page<Product> findByProduct(Pageable pageable, String productType) {
        return iProductRepository.findByPrice(pageable,"%" +productType + "%");
    }
}
