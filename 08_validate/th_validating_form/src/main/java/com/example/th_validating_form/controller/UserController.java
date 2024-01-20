package com.example.th_validating_form.controller;

import com.example.th_validating_form.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("")
    public ModelAndView showCreate(@ModelAttribute("user")User user){
        ModelAndView mv = new ModelAndView("/create");
        return mv;
    }
    @PostMapping("validateUser")
    public ModelAndView validateUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        ModelAndView mv = new ModelAndView("/result");
        if (result.hasErrors()){
            mv = new ModelAndView("/create");
        }
        return mv;
    }


}
