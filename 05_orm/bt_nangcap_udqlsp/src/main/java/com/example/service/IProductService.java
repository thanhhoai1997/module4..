package com.example.service;


import com.example.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findOne(int id);
    void save(Product product);
    void delete(int id);


}
