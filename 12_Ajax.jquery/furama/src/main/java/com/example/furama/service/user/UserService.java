package com.example.furama.service.user;

import com.example.furama.model.User;
import com.example.furama.repositories.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }
}
