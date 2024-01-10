package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public ModelAndView showCreate(@ModelAttribute("customer")Customer customer){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("")
    public ModelAndView create(@ModelAttribute("customer")Customer customer, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.insertWithStoredProcedure(customer);
        attributes.addFlashAttribute("message","create oke");

        return mv;


    }
}
