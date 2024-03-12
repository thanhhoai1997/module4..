package com.example.furama.service.user;

import com.example.furama.model.User;

public interface IUserService {
    User findByUsername(String username);
}
