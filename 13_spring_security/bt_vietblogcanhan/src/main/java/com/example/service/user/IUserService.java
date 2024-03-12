package com.example.service.user;

import com.example.model.User;

public interface IUserService  {
    User findByUsername(String name);

    void save(User user);
}
