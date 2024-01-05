package com.example.service.user;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Menu;
import com.example.model.Slides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IHomeService {
     @Autowired
     List<Slides> getDataSlides();

     List<Category> getDataCategorys();

    List<Menu> getDataMenu();

    List<ProductDto> getDataProductDto();

    List<ProductDto> getDataProductDtoNew();
}
