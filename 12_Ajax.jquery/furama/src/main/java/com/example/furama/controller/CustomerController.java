package com.example.furama.controller;

import com.example.furama.model.Contract;
import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import com.example.furama.model.Employee;
import com.example.furama.model.dto.CustomerDTO;
import com.example.furama.service.contract.IContractService;
import com.example.furama.service.customer.ICustomerService;
import com.example.furama.service.customer.ICustomerTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;


    @GetMapping("")
    public ModelAndView showList(@RequestParam("page")Optional<Integer> page,
                                 @RequestParam("name") Optional<String> name){
        ModelAndView mv = new ModelAndView("/customer/list");
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Customer> customers ;
        if (name.isPresent()){
            customers = iCustomerService.findAllByName(pageable,name.get());
        }else {
            customers = iCustomerService.findAll(pageable);
        }

        List<Integer> numberPages = new ArrayList<>();
        for (int i = 1; i <= customers.getTotalPages();i++){
            numberPages.add(i);
        }
        mv.addObject("customers",customers);
        mv.addObject("numberPages",numberPages);
        return  mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("customer")CustomerDTO customer){
        ModelAndView mv = new ModelAndView("/customer/create");
        mv.addObject("customerTypes",iCustomerTypeService.findAll());
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult bindingResult){
        new CustomerDTO().validate(customerDTO,bindingResult);

        if (bindingResult.hasErrors()){
            return new ModelAndView("/customer/create","customerTypes",iCustomerTypeService.findAll());
        }
        Customer customer = new Customer();
        CustomerType customerType = iCustomerTypeService.findById(customerDTO.getCustomerType());
        BeanUtils.copyProperties(customerDTO,customer);
        customer.setCustomerType(customerType);


        iCustomerService.save(customer);
        return new ModelAndView("redirect:/customer") ;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/customer/edit");
        Customer customer = iCustomerService.findById(id);
        mv.addObject("customerTypes",iCustomerTypeService.findAll());
        mv.addObject("customer",customer);
        return  mv;

    }


    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("customer") Customer customer){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.save(customer);
        return mv;

    }

    @PostMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/customer");
        iCustomerService.deleteById(id);
        return mv;

    }
}
