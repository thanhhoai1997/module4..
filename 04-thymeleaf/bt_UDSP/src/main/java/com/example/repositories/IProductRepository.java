package com.example.repositories;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository {
    List<Product> findAllProduct();
    void saveProduct(Product product);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
    Product findByIdProduct(int id);
}
