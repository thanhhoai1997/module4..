package com.example.repository;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository {
    User ckeckLogin(Login login);
}
