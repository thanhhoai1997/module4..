package com.example.repositories;

import com.example.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICategoryRepository {
    @Autowired
    List<Category> getDataCategorys();

}
