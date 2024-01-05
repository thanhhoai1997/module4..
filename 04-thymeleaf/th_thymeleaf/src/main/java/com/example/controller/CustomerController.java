package com.example.controller;

import com.example.Service.CustomerService;
import com.example.Service.ICustomerService;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService iCustomerService = new CustomerService();
    @GetMapping("")
    public ModelAndView index(){
        List<Customer> customers = iCustomerService.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("customers",customers);
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("customer",new Customer());
        return mv;

    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        customer.setId((int) (Math.random()*10000));
         iCustomerService.save(customer);
        attributes.addFlashAttribute("message","save ok");

        return mv;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showUpdate(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("customer",iCustomerService.findById(id));
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.update(customer.getId(),customer);
        attributes.addFlashAttribute("message","update ok");
        return mv;


    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("delete");
        mv.addObject("customer",iCustomerService.findById(id));
        return mv;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("customer") Customer customer,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.remove(customer.getId());
        attributes.addFlashAttribute("message","delete OK");
        return mv;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("customer",iCustomerService.findById(id));
        return mv;
    }
}
