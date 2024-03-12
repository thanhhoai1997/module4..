package com.example.furama.controller;

import com.example.furama.model.User;
import com.example.furama.repositories.user.IUserRepository;
import com.example.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
@Controller
@SessionAttributes("employee")
public class HomeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("")
    public ModelAndView showHome(){
        ModelAndView mv = new ModelAndView("/layout");



        return mv;
    }
    @GetMapping("/login")
    public ModelAndView showLogin(){
        return  new ModelAndView("/login");
    }
}
