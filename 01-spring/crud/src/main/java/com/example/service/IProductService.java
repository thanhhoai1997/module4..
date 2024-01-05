package com.example.service;

import com.example.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product getProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
