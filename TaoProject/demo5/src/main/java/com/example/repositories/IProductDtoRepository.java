package com.example.repositories;

import com.example.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public interface IProductDtoRepository {
    @Autowired
    List<ProductDto> getDataProductDto();

    List<ProductDto> getDataProductDtoNew();
    List<ProductDto> getAllProductPaginates(int start, int end);

    List<ProductDto> getAllProductById(int id);
}
