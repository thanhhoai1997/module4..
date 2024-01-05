package com.example.service;

import com.example.models.Product;
import com.example.repositories.IProductRepository;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
@Autowired
    private  IProductRepository iProductRepository ;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return iProductRepository.getProductById(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);

    }
}
