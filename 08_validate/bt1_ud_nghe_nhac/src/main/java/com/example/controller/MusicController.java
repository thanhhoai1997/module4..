package com.example.controller;

import com.example.model.Music;

import com.example.model.MusicDTO;
import com.example.service.IMusicService;
import com.example.service.MusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {


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
    public ModelAndView showCreate( @ModelAttribute("music") MusicDTO music ){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("music") MusicDTO music,BindingResult result){

        new MusicDTO().validate(music,result);

        if (result.hasErrors()){
            return new ModelAndView("create");
        }

        Music m = new Music();
        BeanUtils.copyProperties(music,m);

        iMusicService.save(m);
        return new ModelAndView("redirect:/music");



    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete (@PathVariable("id") Long id){
        iMusicService.delete(id);
        return new ModelAndView("redirect:/music");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        MusicDTO  musicDTO = new MusicDTO();
        BeanUtils.copyProperties(iMusicService.findOne(id),musicDTO);
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("music",musicDTO);
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("music") MusicDTO music,BindingResult result){
        new MusicDTO().validate(music,result);
        if (result.hasErrors()){
            return new ModelAndView("edit");
        }
        Music m = new Music();
        BeanUtils.copyProperties(music,m);
        iMusicService.save(m);
        return new ModelAndView("redirect:/music");
    }
}
