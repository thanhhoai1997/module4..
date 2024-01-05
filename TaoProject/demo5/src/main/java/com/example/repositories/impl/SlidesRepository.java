package com.example.repositories.impl;

import com.example.model.Category;
import com.example.model.MapperCategory;
import com.example.model.MapperSlides;
import com.example.model.Slides;


import com.example.repositories.ISlidesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SlidesRepository implements ISlidesRepository {
    @Autowired
   public JdbcTemplate _jdbcTemplate;


@Override
    public List<Slides> getDataSlides() {
        List<Slides> list = new ArrayList<Slides>();
        String sql="select*from slides";
        list = _jdbcTemplate.query(sql, new MapperSlides());
        return list;
    }


}
