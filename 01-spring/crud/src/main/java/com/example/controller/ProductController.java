package com.example.controller;

import com.example.models.Product;
import com.example.service.IProductService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
@Autowired
  private  IProductService iProductService ;
    @GetMapping("/products")
    public ModelAndView list(){
        List<Product> productList = iProductService.findAll();

        ModelAndView mv = new ModelAndView("products/list");
        mv.addObject("products",productList);

        return mv;
    }
    @GetMapping("/new")
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("products/create");
        mv.addObject("product",new Product());
        return mv;

    }
    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        int idRandom = (int) (Math.random()*10000);
        product.setId(idRandom);
        iProductService.save(product);
        ModelAndView mv = new ModelAndView("products/create");
        mv.addObject("message","add oke");
        return mv;
    }
    @GetMapping("/view")
    public ModelAndView showViewProduct(@RequestParam("id") int id){
        Product product = iProductService.getProductById(id);
        ModelAndView mv = new ModelAndView("products/view");
        mv.addObject("product",product);
        return mv;

    }
    @PostMapping("/update")
    public ModelAndView updateProduct(@RequestParam("id") int id,
                                      @ModelAttribute("product") Product product){

        iProductService.updateProduct(id,product);
        ModelAndView mv = new ModelAndView("products/view");
        mv.addObject("message","add oke");
        mv.addObject("product",iProductService.getProductById(id));
        return mv;
    }
    @GetMapping("/delete")
    public ModelAndView deleteProduct(@RequestParam("id") int id ){
        iProductService.deleteProduct(id);
        ModelAndView mv = new ModelAndView("products/list");
        mv.addObject("products",iProductService.findAll());
        return mv;
    }
}
