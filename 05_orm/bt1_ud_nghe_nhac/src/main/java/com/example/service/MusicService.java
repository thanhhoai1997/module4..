package com.example.service;

import com.example.model.Music;
import com.example.repositories.IMusicRepository;
import com.example.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService{
    @Autowired
    private  IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
    iMusicRepository.save(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);

    }

    @Override
    public Music findOne(int id) {

        return iMusicRepository.findOne(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }
}
