package com.example.th_qlkh_tinh.service;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remote(Long id);

}
