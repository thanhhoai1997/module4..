package com.example.repositories.impl;

import com.example.model.Category;
import com.example.model.MapperCategory;
import com.example.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepository implements ICategoryRepository {
    @Autowired
    public JdbcTemplate _jdbcTemplate;
    @Override
    public List<Category> getDataCategorys() {
        List<Category> list = new ArrayList<>();
        String sql = "select *from categorys";
        list = _jdbcTemplate.query(sql, new MapperCategory());
        return list ;
    }
}
