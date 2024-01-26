package com.example.bt_ungdungmuonsach.service.category;

import com.example.bt_ungdungmuonsach.model.Book;
import com.example.bt_ungdungmuonsach.model.Category;
import com.example.bt_ungdungmuonsach.repositories.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Book> findAllByNameCategory(String s, Pageable pageable) {
        return iCategoryRepository.findAllByNameCategory(s,pageable);
    }
}
