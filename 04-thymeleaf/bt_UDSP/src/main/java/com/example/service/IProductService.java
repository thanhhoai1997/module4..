package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    List<Product> findAllProduct();
    void saveProduct(Product product);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
    Product findByIdProduct(int id);
}
