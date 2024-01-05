package com.example.controller.user;

import com.example.service.user.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class BaseController {
    @Autowired
    IHomeService _homeService ;
    public ModelAndView _mvShare = new ModelAndView();
    @PostConstruct
    public ModelAndView Init(){
        _mvShare.addObject("menu",_homeService.getDataMenu());
        return _mvShare;
    }
}
