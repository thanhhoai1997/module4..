package com.example.service;

import com.example.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    void delete(int id);
    Music findOne(int id);
    void update(Music music);
}
