package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void remove(int id);
}
