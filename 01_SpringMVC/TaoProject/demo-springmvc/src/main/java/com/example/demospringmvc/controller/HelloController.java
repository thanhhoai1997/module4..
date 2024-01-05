package com.example.demospringmvc.controller;

import com.example.demospringmvc.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private Hello hello;
    @RequestMapping("hello")
    public String hello(){
    String str = hello.getName();
    return str;
    }
}
