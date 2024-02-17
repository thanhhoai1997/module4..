package com.example.th_themspvaogiohang.repositories;

import com.example.th_themspvaogiohang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
