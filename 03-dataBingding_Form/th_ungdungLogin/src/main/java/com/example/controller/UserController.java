package com.example.controller;

import com.example.model.Login;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home","login",new Login());
        return mv;
    }
    @PostMapping("/login")
    public ModelAndView getInfo(@ModelAttribute("login") Login login){
        User user = iUserService.ckeckLogin(login);

        if (user == null){
            ModelAndView mv = new ModelAndView("error");
            return mv;

        }else {
            ModelAndView mv = new ModelAndView("user");
            mv.addObject("user",user);
            return mv;
        }
    }
}
