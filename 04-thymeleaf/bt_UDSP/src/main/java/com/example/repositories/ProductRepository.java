package com.example.repositories;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add( new Product(1,"IPhone-6",140000,"Auth","Apple"));
        products.add( new Product(2,"IPhone-7",150000,"Rep","Apple"));
        products.add( new Product(3,"IPhone-8",160000,"Auth","Apple"));
        products.add( new Product(4,"IPhone-X",170000,"Rep","Apple"));
        products.add( new Product(5,"IPhone-Xs",1800000,"Auth","Apple"));
        products.add( new Product(6,"IPhone-11",200000,"Rep","Apple"));
        products.add( new Product(7,"IPhone-12",230000,"Auth","Apple"));
    }
    @Override
    public List<Product> findAllProduct() {
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);

    }

    @Override
    public void updateProduct(int id, Product product) {
        for (Product p: products
             ) {
            if (p.getId() == id){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacture(product.getManufacture());
                break;

            }

        }

    }

    @Override
    public void deleteProduct(int id) {
        for (Product p: products
             ) {
            if (p.getId() == id){
                products.remove(p);
                break;
            }

        }

    }

    @Override
    public Product findByIdProduct(int id) {
        for (Product p: products
             ) {
            if (p.getId() == id){
                return p;
            }

        }
        return null;
    }
}
