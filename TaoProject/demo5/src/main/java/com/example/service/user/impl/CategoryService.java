package com.example.service.user.impl;

import com.example.dto.ProductDto;
import com.example.repositories.IProductDtoRepository;
import com.example.service.user.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private IProductDtoRepository iProductDtoRepository ;

    @Override
    public List<ProductDto> getAllProductById(int id) {
        return iProductDtoRepository.getAllProductById(id);
    }

    @Override
    public List<ProductDto> getDataProductPaginates(int start, int end) {
        return iProductDtoRepository.getAllProductPaginates(start,end);
    }
}
