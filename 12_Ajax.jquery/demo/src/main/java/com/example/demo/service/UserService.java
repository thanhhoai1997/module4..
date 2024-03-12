package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
      return   iUserRepository.findAll();

    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        iUserRepository.deleteById(id);

    }
}
