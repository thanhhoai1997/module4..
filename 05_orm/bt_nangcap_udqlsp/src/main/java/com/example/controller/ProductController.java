package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService = new ProductService();
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("list");
        List<Product> list = iProductService.findAll();
        mv.addObject("products",list);
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("product") Product product){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("product") Product product){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.save(product);
        return mv;

    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("product",iProductService.findOne(id));
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("product") Product product){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.save(product);
        return mv;
    }
    @GetMapping("{id}/view")
    public ModelAndView showView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("product",iProductService.findOne(id));
        return mv;
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.delete(id);
        return mv;
    }
}
