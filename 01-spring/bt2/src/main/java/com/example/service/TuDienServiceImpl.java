package com.example.service;

import com.example.repositories.ITuDienRepository;
import com.example.repositories.TuDienRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuDienServiceImpl implements ITuDienService{
    @Autowired
    private ITuDienRepository iTuDienRepository ;
    @Override
    public String search(String english) {
        return iTuDienRepository.search(english);
    }
}
