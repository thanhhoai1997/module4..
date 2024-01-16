package com.example.controller;

import com.example.model.Category;
import com.example.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("category")Category category){
        ModelAndView mv = new ModelAndView("createCategory");
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("category") Category category){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iCategoryService.save(category);
        return mv;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("editCategory");
        mv.addObject("category",iCategoryService.findById(id));
        return mv;
    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("category") Category category){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iCategoryService.save(category);
        return mv;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iCategoryService.delete(id);
        return mv;
    }


}
