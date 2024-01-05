package com.example.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface ITuDienRepository {

    String search(String english);
}
