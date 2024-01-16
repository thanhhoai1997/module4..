package com.example.th_qlkh_tinh.controller;

import com.example.th_qlkh_tinh.model.Customer;
import com.example.th_qlkh_tinh.model.Province;
import com.example.th_qlkh_tinh.service.customer.ICustomerService;
import com.example.th_qlkh_tinh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IProvinceService iProvinceService;

    @ModelAttribute("provinces")
    Iterable<Province> getProvinces() {
        return iProvinceService.findAll();
    }

    @GetMapping("")
    public ModelAndView showListCustomers(@RequestParam("page") Optional<Integer> page,@RequestParam("search") Optional<String> search) {
        Sort sort =Sort.by("firstName").ascending();
       Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Customer> customers ;
        if (search.isPresent()){
           customers =  iCustomerService.findAllByFirstNameContaining(search.get(),pageable);

        }else {
            customers = iCustomerService.findAll(pageable);
        }

        ModelAndView mv = new ModelAndView("/customer/list");
        mv.addObject("customers", customers);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv = new ModelAndView("/customer/create");
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("customer") Customer customer, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.save(customer);
        attributes.addFlashAttribute("message", "add oke");
        return mv;

    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }


    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("customer")Customer customer,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.save(customer);
        attributes.addFlashAttribute("message","update oke");
        return mv;

}
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable("id")Long id){
        ModelAndView mv = new ModelAndView("/customer/delete");
        Optional<Customer> customer = iCustomerService.findById(id);
        mv.addObject("customer",customer.get());
        return mv;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("customer") Customer customer){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.remote(customer.getId());
        return mv;
    }

}
