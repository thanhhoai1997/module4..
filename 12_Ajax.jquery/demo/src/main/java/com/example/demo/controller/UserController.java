package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

   @Autowired
   private IUserService iUserService;

    @PostMapping("/user")
    public User create(@RequestBody User user){
        iUserService.save(user);
        return user;

    }
    @GetMapping("/users")
    public List<User> findAll(){
        return iUserService.findAll();
    }
    @DeleteMapping("/user")
    public void delete(@RequestParam("id") Long id){
        iUserService.remove(id);
    }
    @PutMapping("/user")
    public void update(@RequestBody User user){
        iUserService.save(user);
    }
}
