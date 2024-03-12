package com.example.furama.repositories.user;

import com.example.furama.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query("select u from User as u where u.username = :username")
    User findByUsername(@Param("username") String username);
}
