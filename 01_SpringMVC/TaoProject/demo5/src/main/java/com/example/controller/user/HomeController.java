package com.example.controller.user;

import com.example.service.user.IHomeService;
import com.example.service.user.impl.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    @RequestMapping({"/","/trang-chu"})
    public ModelAndView Index(){
//        ModelAndView mv = new ModelAndView("user/index");
        _mvShare.addObject("slides",_homeService.getDataSlides());
        _mvShare.addObject("category",_homeService.getDataCategorys());
        _mvShare.addObject("productdto",_homeService.getDataProductDto());
        _mvShare.addObject("productdto1",_homeService.getDataProductDtoNew());

        _mvShare.setViewName("user/index");

        return _mvShare;

    }
    @RequestMapping(value = "product")
    public ModelAndView Product(){
        ModelAndView mv = new ModelAndView("user/product");
        return mv;
    }
}
