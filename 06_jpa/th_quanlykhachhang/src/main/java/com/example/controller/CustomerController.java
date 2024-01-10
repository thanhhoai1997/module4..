package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("customers",iCustomerService.findAll());
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("customer")Customer customer){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("customer") Customer customer){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.save(customer);
        return mv;
    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("edit");
       Customer customer = iCustomerService.findById(id);
        mv.addObject("customer",customer);
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("customer") Customer customer,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.save(customer);
        attributes.addFlashAttribute("message","update oke");
        return mv;
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.delete(id);
        return mv;
    }

}
