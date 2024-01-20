package com.example.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {
    private Long id;
//    @NotBlank(message = "khong duoc de trong")
//    @Size(max = 800,message = "<=800 character")
//    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "k chua ki tu dac biet")
    private String name;

//    @NotBlank(message = "khong duoc phep de trong")
//    @Size(max = 300,message = "<= 300 character")
//    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "khong chua ki tu dac biet")
    private String artist;


//    @NotBlank
//    @Size(max = 1000,message = "<=1000 character")
//    @Pattern(regexp = "^[a-zA-Z0-9,]+$",message = "khong chua ki tu dac biet ")
    private String kindOfMusic;

    public MusicDTO() {
    }

    public MusicDTO(Long id, String name, String artist, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

        MusicDTO musicDTO = (MusicDTO) target;
        String name = musicDTO.getName();
        String artist = musicDTO.getArtist();
        String kindOfMusic = musicDTO.getKindOfMusic();

        if (name.equals("")){
            errors.rejectValue("name","","khong duoc de trong");
        } else if (name.length() > 800){
            errors.rejectValue("name","","k vuot qua 800 ki tu");
        }else if (!name.matches("^[a-zA-Z0-9 ]+$")){
            errors.rejectValue("name","","khong chua ki tu dac biet");
        }

        if (artist.equals("")){
            errors.rejectValue("artist","","khong duoc de trong");
        }else if (artist.length() > 300){
            errors.rejectValue("artist","","k vuot qua 800 ki tu");
        }else if (!artist.matches("^[a-zA-Z0-9 ]+$")){
            errors.rejectValue("artist","","khong chua ki tu dac biet");
        }



        if (kindOfMusic.equals("")){
            errors.rejectValue("kindOfMusic","","khong duoc de trong");
        }else if (kindOfMusic.length() > 1000){
            errors.rejectValue("kindOfMusic","","k vuot qua 1000 ki tu");
        }else if (!kindOfMusic.matches("^[a-zA-Z0-9, ]+$")){
            errors.rejectValue("kindOfMusic","","khong chua ki tu dac biet");
        }

    }
}
