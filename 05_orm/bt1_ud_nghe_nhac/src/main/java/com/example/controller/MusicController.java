package com.example.controller;

import com.example.model.Music;
import com.example.model.MusicForm;
import com.example.service.IMusicService;
import com.example.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private  IMusicService iMusicService;
    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("list");
        List<Music> musicList = iMusicService.findAll();
        mv.addObject("musics",musicList);
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("musicForm")MusicForm musicForm){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("musicForm") MusicForm musicForm){
        MultipartFile multipartFile = musicForm.getMultipartFile();
        String filename = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMultipartFile().getBytes(), new File(fileUpload + filename) );


        }catch (IOException e){
            e.printStackTrace();
        }
        Music music = new Music();
        music.setName(musicForm.getName());
        music.setArtist(musicForm.getArtist());
        music.setKindOfMusic(musicForm.getKindOfMusic());
        music.setPath(filename);
        iMusicService.save(music);
        ModelAndView mv = new ModelAndView("redirect:/music");
        return mv;



    }
}
