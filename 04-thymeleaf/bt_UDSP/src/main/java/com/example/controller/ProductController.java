package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    private IProductService iProductService = new ProductService() ;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("products",iProductService.findAllProduct());
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView mv = new ModelAndView("create");
        mv.addObject("product",new Product());
        return mv;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("product") Product product, RedirectAttributes attributes){
        product.setId((int) (Math.random()*10000));
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.saveProduct(product);
        attributes.addFlashAttribute("message","save oke");
        return mv;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("product",iProductService.findByIdProduct(id));
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("product") Product product,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.updateProduct(product.getId(),product);
        attributes.addFlashAttribute("message","update oke");
        return mv;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("delete");
        mv.addObject("product",iProductService.findByIdProduct(id));
        return mv;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("product") Product product,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/product");
        iProductService.deleteProduct(product.getId());
        attributes.addFlashAttribute("message","delete oke");
        return mv;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("view");
        mv.addObject("product",iProductService.findByIdProduct(id));
        return mv;
    }

}
