package com.example.furama.controller;

import com.example.furama.model.Employee;
import com.example.furama.service.employee.IDivisionService;
import com.example.furama.service.employee.IEducationDegreeService;
import com.example.furama.service.employee.IEmployeeService;
import com.example.furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("")
    public ModelAndView showList(@RequestParam("page")Optional<Integer> page,@RequestParam("name") Optional<String> name){
        ModelAndView mv = new ModelAndView("/employee/list");
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Employee> employees ;
        if (name.isPresent()){
          employees=  iEmployeeService.findByName(pageable,name.get());
        }else {
          employees=  iEmployeeService.findAll(pageable);
        }
        List<Integer> numberPages = new ArrayList<>();
        for (int i = 1; i <= employees.getTotalPages(); i++){
            numberPages.add(i);
        }
        mv.addObject("employees",employees);
        mv.addObject("numberPages",numberPages);
        return mv;

    }

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("employee")Employee employee){


        ModelAndView mv = new ModelAndView("/employee/create");
        mv.addObject("positions",iPositionService.findAll());
        mv.addObject("educationDegrees",iEducationDegreeService.findAll());
        mv.addObject("divisions",iDivisionService.findAll());
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("employee") Employee employee){
        ModelAndView mv = new ModelAndView("redirect:/employee");
        iEmployeeService.save(employee);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/employee/edit");
        Employee employee = iEmployeeService.findById(id);
        mv.addObject("employee",employee);
        mv.addObject("positions",iPositionService.findAll());
        mv.addObject("educationDegrees",iEducationDegreeService.findAll());
        mv.addObject("divisions",iDivisionService.findAll());
        return mv;

    }

    @PostMapping("/edit")
    public  ModelAndView update(@ModelAttribute("employee")Employee employee){
        ModelAndView mv = new ModelAndView("redirect:/employee");
        iEmployeeService.save(employee);
        return mv;



    }

    @PostMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/employee");
        iEmployeeService.deleteById(id);
        return mv;
    }
}
