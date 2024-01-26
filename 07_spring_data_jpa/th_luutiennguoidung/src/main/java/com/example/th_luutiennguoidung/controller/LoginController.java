package com.example.th_luutiennguoidung.controller;

import com.example.th_luutiennguoidung.model.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm(){
        return new User();
    }
    @GetMapping("/login")
    public ModelAndView index(@CookieValue(value = "setUser",defaultValue = "") String setUser){
        ModelAndView mv = new ModelAndView("/login");
        Cookie cookie = new Cookie("setUser",setUser);

        mv.addObject("cookieValue",cookie);
        return mv;
    }
    @PostMapping("/dologin")
    public ModelAndView doLogin(@ModelAttribute("user") User user, @CookieValue(value = "setUser",defaultValue = "") String setUser,
                                HttpServletResponse response, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("/login");
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("1245")){
            if (user.getEmail()!=null){
                setUser = user.getEmail();
                Cookie cookie = new Cookie("setUser",setUser);
                cookie.setMaxAge(24*60*60);
                response.addCookie(cookie);

                Cookie[] cookies = request.getCookies();

                for (Cookie ck: cookies
                     ) {
                    if (ck.getName().equals("setUser")){
                        mv.addObject("cookieValue",ck);
                        break;

                    }else {
                        ck.setValue("");
                        mv.addObject("cookieValue",ck);
                        break;
                    }

                }
            }
        }else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser",setUser);
            mv.addObject("cookieValue",cookie);
            mv.addObject("message","Login failed. Try again.");
        }
        return mv;
    }
}
