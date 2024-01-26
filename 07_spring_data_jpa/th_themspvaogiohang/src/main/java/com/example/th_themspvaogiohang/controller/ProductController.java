package com.example.th_themspvaogiohang.controller;

import com.example.th_themspvaogiohang.model.Cart;
import com.example.th_themspvaogiohang.model.Product;
import com.example.th_themspvaogiohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView mv = new ModelAndView("/shop");
        mv.addObject("products",iProductService.findAll());
        return mv;
    }
    @GetMapping("/add/{id}")
    public ModelAndView addToCart(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart, @RequestParam(value = "action",defaultValue = "") String action){
        Product product = iProductService.findById(id);
        if (action.equals("show")){
            cart.addProduct(product);
            return new ModelAndView("redirect:/shopping-cart");
        }
        cart.addProduct(product);
        return new ModelAndView("redirect:/shop");

    }
}
