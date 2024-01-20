package com.example.service;

import com.example.model.Music;
import com.example.repositories.IMusicRepository;

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
    public void delete(Long id) {
        iMusicRepository.deleteById(id);

    }

    @Override
    public Music findOne(Long id) {

        return iMusicRepository.findById(id).get();
    }


}
