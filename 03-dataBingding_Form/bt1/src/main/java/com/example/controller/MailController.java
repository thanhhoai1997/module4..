package com.example.controller;

import com.example.model.Mail;
import com.example.repositorys.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    IMailRepository iMailRepository;

    @GetMapping
    public ModelAndView showMail(){
        ModelAndView mv = new ModelAndView("settings");
        mv.addObject("mail", new Mail());
        mv.addObject("listLanguages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"} );
        mv.addObject("listPageSize", new Integer[]{ 5, 10, 15, 25, 50, 100});
        return mv;

    }
    @PostMapping("/update")
    public String updateMail(@ModelAttribute("mail") Mail mail, ModelMap mv){



            iMailRepository.updateMail(mail.getId(),mail);

                mv.addAttribute("mail",mail);


        mv.addAttribute("listLanguages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"} );
        mv.addAttribute("listPageSize", new Integer[]{ 5, 10, 15, 25, 50, 100});
        mv.addAttribute("message","update ok");
        return "settings";



    }
}
