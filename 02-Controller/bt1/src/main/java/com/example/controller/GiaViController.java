package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class GiaViController {
    @RequestMapping("/a")
    public String showCondiment(){

        return "list";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
   public String save(@RequestParam("condiment") String[] condiment,ModelMap modelMap){
        modelMap.addAttribute("condiment",condiment);
        return "info";

   }

}
