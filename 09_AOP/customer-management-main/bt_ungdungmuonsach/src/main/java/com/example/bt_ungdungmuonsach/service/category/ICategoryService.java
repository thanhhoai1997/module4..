package com.example.bt_ungdungmuonsach.service.category;

import com.example.bt_ungdungmuonsach.model.Book;
import com.example.bt_ungdungmuonsach.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();


    Page<Book> findAllByNameCategory(String s, Pageable pageable);
}
