package com.example.repositories;

import com.example.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    void save (Blog blog);
    void delete(int id);
    Blog findOne(int id);
}
