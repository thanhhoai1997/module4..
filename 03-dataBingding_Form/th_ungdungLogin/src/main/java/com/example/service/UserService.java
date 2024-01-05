package com.example.service;

import com.example.model.Login;
import com.example.model.User;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User ckeckLogin(Login login) {
        return iUserRepository.ckeckLogin(login);
    }
}
