package com.example.repositories.user;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    @Query("select u from User as u where u.username = :username")
    User findByUsername(@Param("username") String username);
//    User findByUsername(String username);

}
