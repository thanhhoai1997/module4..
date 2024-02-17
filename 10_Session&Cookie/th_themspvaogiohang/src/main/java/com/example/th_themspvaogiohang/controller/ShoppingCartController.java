package com.example.th_themspvaogiohang.controller;

import com.example.th_themspvaogiohang.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return  new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart){
        ModelAndView mv = new ModelAndView("/cart");
        int[] number = {1,2,3,4,5};
        mv.addObject("totalProduct",number);
        mv.addObject("cart",cart);
        return mv;
    }
    @GetMapping("/pay")
    public ModelAndView payCart(@SessionAttribute("cart") Cart cart){
        ModelAndView mv = new ModelAndView("/pay");
        mv.addObject(cart);
        return mv;
    }
}
