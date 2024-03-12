package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
    @GetMapping("/test")
    public ModelAndView showTest(){
        return new ModelAndView("/test");
    }
    @GetMapping("/test2")
    public ModelAndView showTest2(){
        return new ModelAndView("/test2");
    }
}
