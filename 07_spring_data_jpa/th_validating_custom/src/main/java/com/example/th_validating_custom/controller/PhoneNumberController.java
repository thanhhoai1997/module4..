package com.example.th_validating_custom.controller;

import com.example.th_validating_custom.model.PhoneNumber;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/phonenumber")
public class PhoneNumberController {
    @GetMapping("")
    public ModelAndView showCreate(@ModelAttribute("phoneNumber")PhoneNumber phoneNumber){
        ModelAndView mv = new ModelAndView("/create");
        return mv;
    }
    @PostMapping("/validatePhoneNumber")
    public ModelAndView validatePhoneNumber(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult result
                                            ){
        ModelAndView mv = new ModelAndView("/result");
        new PhoneNumber().validate(phoneNumber,result);
        if (result.hasErrors()){
            mv = new ModelAndView("/create");
        }
        return mv;
    }
}
