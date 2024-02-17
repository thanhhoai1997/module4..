package com.example.service.blog;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save (Blog blog);
    void delete(Long id);
    Blog findOne(Long id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitle(String title,Pageable pageable);

    Page<Blog> findAllByCategoryName(String s, Pageable pageable);
}
