package com.example.service.user;

import com.example.model.User;
import com.example.repositories.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public User findByUsername(String name) {
        return iUserRepository.findByUsername(name);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
