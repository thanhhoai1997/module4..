package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Integer id;
    private String name;
    private String artist;
    private String kindOfMusic;
    private MultipartFile multipartFile;

    public MusicForm(Integer id, String name, String artist, String kindOfMusic, MultipartFile multipartFile) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
        this.multipartFile = multipartFile;
    }

    public MusicForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
