package com.example.repositories;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findOne(int id);
    void save(Product product);
    void delete(int id);
}
