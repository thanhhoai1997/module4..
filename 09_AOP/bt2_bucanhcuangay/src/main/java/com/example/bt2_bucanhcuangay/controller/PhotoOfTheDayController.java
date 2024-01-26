package com.example.bt2_bucanhcuangay.controller;

import com.example.bt2_bucanhcuangay.model.Comment;
import com.example.bt2_bucanhcuangay.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/photooftheday")
public class PhotoOfTheDayController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("")
    public ModelAndView showPhoto(@ModelAttribute("comment") Comment comment,
                                  @RequestParam("page")Optional<Integer> page){
        ModelAndView mv = new ModelAndView("/index");
        Sort sort = Sort.by("timeComment").descending();
        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Comment> comments = iCommentService.findAll(pageable);
        mv.addObject("comments",comments);
        return mv;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(){
        return  new ModelAndView("/error_page");

    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("comment")Comment comment){
        String[] commentError = {"xau","dep"};
        String[] comment1 = comment.getFeedBack().split(" ");
        for (String c: commentError
             ) {
            for (String c1: comment1
                 ) {
                if (c.equals(c1)){
                    throw new InputMismatchException();
                }

            }

        }
        Date date = new Date();
        comment.setTimeComment(date);
        iCommentService.save(comment);
        ModelAndView mv = new ModelAndView("redirect:/photooftheday");
        return mv;

    }

}
