package com.example.bt_validate_form.controller;

import com.example.bt_validate_form.model.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    @RequestMapping("/show-create")
    public ModelAndView showForm(@ModelAttribute("user")UserDTO user){
        ModelAndView mv = new ModelAndView("/create");
        return mv;
    }
    @PostMapping("/validateUser")
    public ModelAndView validateUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult){
        new UserDTO().validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/create");
        }


        return new ModelAndView("/resutl");
    }
}
