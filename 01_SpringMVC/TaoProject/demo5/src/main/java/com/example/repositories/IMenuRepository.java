package com.example.repositories;

import com.example.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository {
    @Autowired
    List<Menu> getDataMenu();
}
