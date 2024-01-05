package com.example.controller;

import com.example.service.ITuDienService;
import com.example.service.TuDienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/tudien")
public class TuDienController {

    private ITuDienService iTuDienService = new TuDienServiceImpl();

    @GetMapping
    public String showForm(){

        return "form";
    }
    @PostMapping("/tracuu")
    public ModelAndView getInfo(@RequestParam("english") String english ){
        ModelAndView mv = new ModelAndView("info");
      String vn =   iTuDienService.search(english);
        if (vn != null){
            mv.addObject("vn",vn);
            mv.addObject("english",english);
        }else {
            mv.addObject("message","khong tim thay");
        }
        return mv;
    }

}
