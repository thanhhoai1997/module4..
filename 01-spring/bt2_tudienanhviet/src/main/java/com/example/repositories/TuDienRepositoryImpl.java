package com.example.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TuDienRepositoryImpl implements ITuDienRepository{
   private static Map<String,String> map  ;
    static {
        map.put("hello","xin chao");
        map.put("mark","diem");
        map.put("love","yeu");

    }
    @Override
    public String search(String english) {
        return map.get(english.trim().toLowerCase());
    }
}
