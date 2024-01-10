package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.impl.HibernateCustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    private CustomerService customerService = new HibernateCustomerServiceImpl();
    @GetMapping("")
    public ModelAndView showListCustomers(){
        ModelAndView mv = new ModelAndView("list");
        List<Customer> customers = customerService.findAll();
        mv.addObject("customers",customers);
        return mv;

    }
    @GetMapping("{id}/view")
    public ModelAndView showView(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("customer",customerService.findOne(id));
        return mv;
    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("customer",customerService.findOne(id));
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        attributes.addFlashAttribute("message","update oke");
        return mv;

    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("customer") Customer customer){

        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        customerService.save(customer);
        attributes.addFlashAttribute("message","save oke");
        return mv;
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        customerService.delete(id);
        return mv;
    }


}
