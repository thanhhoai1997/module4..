package com.example.service;

import com.example.model.Product;
import com.example.repositories.IProductRepository;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{

    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAllProduct() {
        return iProductRepository.findAllProduct();
    }

    @Override
    public void saveProduct(Product product) {
    iProductRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepository.updateProduct(id,product);

    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public Product findByIdProduct(int id) {
        return iProductRepository.findByIdProduct(id);
    }
}
