package com.example.controller;

import com.example.model.Comment;
import com.example.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/photooftheday")
public class PhotoOfTheDayController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("")
    public ModelAndView showPhoto(@ModelAttribute("comment")Comment comment){
        ModelAndView mv = new ModelAndView("index");
        List<Comment> comments = iCommentService.findAll();
        mv.addObject("comments",comments);
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("comment")Comment comment){
        Date date = new Date();
        comment.setTimeComment(date);
        iCommentService.save(comment);
        ModelAndView mv = new ModelAndView("redirect:/photooftheday");
        return mv;

    }

}
