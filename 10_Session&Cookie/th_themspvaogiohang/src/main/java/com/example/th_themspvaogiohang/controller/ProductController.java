package com.example.th_themspvaogiohang.controller;

import com.example.th_themspvaogiohang.model.Cart;
import com.example.th_themspvaogiohang.model.Product;
import com.example.th_themspvaogiohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ModelAndView showShop(@RequestParam("page")Optional<Integer> page){
        Pageable pageable = PageRequest.of(page.orElse(0),4);
        List<Integer> pageSize =new ArrayList<>();

        Page<Product> products =iProductService.findAll(pageable);
        for (int i = 1 ; i <= products.getTotalPages() ; i++){
            pageSize.add(i);
        }
        ModelAndView mv = new ModelAndView("/shop");
        mv.addObject("products",products);
        mv.addObject("pageSize",pageSize);

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
    @GetMapping("/view/{id}")
    public  ModelAndView showViewProduct(@PathVariable("id") Long id){
       Product product = iProductService.findById(id);
        ModelAndView mv = new ModelAndView("/view");
        mv.addObject("product",product);
        return mv;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute("cart") Cart cart, @PathVariable("id") Long id){
       Product product = iProductService.findById(id);
       cart.remoteProduct(product);
        ModelAndView mv = new ModelAndView("redirect:/shopping-cart");
        return mv;
    }
    @PostMapping("/pay")
    public  ModelAndView payCart(@ModelAttribute("cart") Cart cart){
        cart.getProducts().clear();
        return  new ModelAndView("/thanks");
    }

//    @GetMapping("/pay")
//    public ModelAndView pay(@ModelAttribute("cart") Cart cart){
//        ModelAndView mv = new ModelAndView("/pay");
//    }
}
