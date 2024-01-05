package com.example.repositories;

import com.example.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository  {
    List<Product> findAll();

    void save(Product product);

    Product getProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
