package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @GetMapping
    public String showCalculator(){
        return "index";
    }
    @PostMapping
    public ModelAndView getResult(@RequestParam double num1,
                                  @RequestParam double num2,
                                  @RequestParam String calculation)
    {
        ModelAndView mv = new ModelAndView("index");

        if (calculation.equals("Addition(+)")){
            mv.addObject("result", num1+num2);
        }else if (calculation.equals("Subtraction(-)")){
            mv.addObject("result",num1-num2);
        } else if (calculation.equals("Multiplication(X)")) {
            mv.addObject("result",num1*num2);

        }else {
            mv.addObject("result",num1/num2);
        }
        return mv;
    }

}
