package com.example.repositories;

import com.example.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static final Map<Integer, Product> product1 ;
    static {
        product1 = new HashMap<>();
        product1.put(1, new Product(1, "GTFS", "Fender Stratocaster", 1200));
        product1.put(2, new Product(2, "GTFT", "Fender Telecaster", 1400));
        product1.put(3, new Product(3, "GTLP", "Gibson Les Paul", 2200));
        product1.put(4, new Product(4, "GTGS", "Gibson SG", 1410));
        product1.put(5, new Product(5, "GTFV", "Gibson Flying V", 13200));
        product1.put(6, new Product(6, "GTSS", "Superstrat", 4200));

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        for(Map.Entry<Integer,Product> entry: product1.entrySet()){
            products.add(entry.getValue());

        }
        return products ;
    }

    @Override
    public void save(Product product) {
        product1.put(product.getId(),product);
    }

    @Override
    public Product getProductById(int id) {
        return product1.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        product1.replace(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        product1.remove(id);
    }
}
