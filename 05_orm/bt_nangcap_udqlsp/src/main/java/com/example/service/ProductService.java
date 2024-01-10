package com.example.service;

import com.example.model.Product;
import com.example.repositories.IProductRepository;
import com.example.repositories.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findOne(int id) {
        return iProductRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }
}
