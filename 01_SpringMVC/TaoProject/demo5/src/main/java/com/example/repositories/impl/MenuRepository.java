package com.example.repositories.impl;

import com.example.model.MapperMenu;
import com.example.model.Menu;
import com.example.repositories.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepository implements IMenuRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Menu> getDataMenu() {
        List<Menu> list = new ArrayList<>();
        String sql = "select *from menus";
        list = jdbcTemplate.query(sql,new MapperMenu());
        return list;
    }
}
