package com.example.service.user;

import com.example.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICategoryService {
    public List<ProductDto> getAllProductById(int id);
    public List<ProductDto> getDataProductPaginates(int start, int end);

}
