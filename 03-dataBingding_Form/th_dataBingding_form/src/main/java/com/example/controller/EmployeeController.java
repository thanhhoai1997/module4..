package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee/")
public class EmployeeController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("employee/create");
        mv.addObject("employee",new Employee());
        return mv;
    }
    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    public ModelAndView getInfo(@ModelAttribute("employee") Employee employee){
        ModelAndView mv = new ModelAndView("employee/info");
        mv.addObject("employee",employee);
        return mv;
    }
}
