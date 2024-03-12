package com.example.thi_module.repositories;

import com.example.thi_module.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product as p where p.name like :name")
    Page<Product> findByName(Pageable pageable, @Param("name") String name);
    @Query("select p from Product as p where p.price = :price")
    Page<Product> findByPrice(Pageable pageable, @Param("price") String price);
    @Query("select p from Product as p where p.productType.name like :productType")
    Page<Product> findByProductType(Pageable pageable,@Param("productType") String productType);
}
