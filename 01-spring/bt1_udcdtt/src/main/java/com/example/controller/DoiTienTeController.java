package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/cdtt")
@Controller
public class DoiTienTeController {
    @GetMapping
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("form");
        return  mv;

    }

    @PostMapping
    public ModelAndView doiTien(@RequestParam("priceUSD") double priceUSD){
        ModelAndView mv = new ModelAndView("form");
        double priceVND = priceUSD*23000;
        mv.addObject("priceVND",priceVND);
        return mv;
    }

}
