package com.example.service.category;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void delete(Long id);
    Category findById(Long id);

}
