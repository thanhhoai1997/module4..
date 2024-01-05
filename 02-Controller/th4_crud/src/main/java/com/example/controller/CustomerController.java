package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("customers/list");
        List<Customer> list = customerService.findAll();
        mv.addObject("customers",list);
        return mv;
    }
    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        mv.addObject("customer",customer);
        return mv;
    }
    @PostMapping
    public String updateCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";


    }



}
