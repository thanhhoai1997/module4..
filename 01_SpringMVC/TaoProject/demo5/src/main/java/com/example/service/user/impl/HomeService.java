package com.example.service.user.impl;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Menu;
import com.example.model.Slides;

import com.example.repositories.IMenuRepository;
import com.example.repositories.IProductDtoRepository;
import com.example.repositories.ISlidesRepository;
import com.example.repositories.ICategoryRepository;
import com.example.repositories.impl.ProductDtoRepository;
import com.example.service.user.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeService implements IHomeService {
    @Autowired
    private ISlidesRepository slidesRepository ;
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private IMenuRepository iMenuRepository;
    @Autowired
    private IProductDtoRepository iProductDtoRepository = new ProductDtoRepository();
    @Override
    public List<Slides> getDataSlides() {
        return slidesRepository.getDataSlides() ;
    }

    @Override
    public List<Category> getDataCategorys() {
        return iCategoryRepository.getDataCategorys();
    }

    @Override
    public List<Menu> getDataMenu() {
        return iMenuRepository.getDataMenu();
    }

    @Override
    public List<ProductDto> getDataProductDto() {
        return iProductDtoRepository.getDataProductDto();
    }

    @Override
    public List<ProductDto> getDataProductDtoNew() {
        return iProductDtoRepository.getDataProductDtoNew();
    }
}
