package com.example.controller.user;

import com.example.dto.PaginateDto;
import com.example.service.user.ICategoryService;
import com.example.service.user.IPaginatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController extends BaseController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IPaginatesService iPaginatesService;
    @RequestMapping(value = "/san-pham/{id}")
    public ModelAndView product(@PathVariable String id){
        _mvShare.setViewName("user/products/category");


        int totalData = iCategoryService.getAllProductById(Integer.parseInt(id)).size();
        PaginateDto paginateDto = new PaginateDto(totalData,9,1);
        _mvShare.addObject("paginateInfo",paginateDto);
        _mvShare.addObject("AllProductPaginate",iCategoryService.getDataProductPaginates(paginateDto.getStart(),paginateDto.getEnd()));

        return _mvShare;
    }
}
