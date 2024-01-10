package com.example.repositories;

import com.example.model.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    void delete(int id);
    Music findOne(int id);

    void update(Music music);
}
