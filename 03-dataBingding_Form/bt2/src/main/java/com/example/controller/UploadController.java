package com.example.controller;

import com.example.model.Upload;
import com.example.service.UploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/baihat")
public class UploadController {
    UploadFileService uploadFileService = new UploadFileService();
    @GetMapping("upload")
    public ModelAndView showForm(){
        ModelAndView mv  = new ModelAndView("/upload");
        mv.addObject("upload",new Upload());
        return mv;
    }
    @PostMapping("upload")
    public String upload (@ModelAttribute("upload") Upload upload, ModelMap model) throws IOException {

        uploadFileService.uploadFile(upload.getFile());
        uploadFileService.save(upload);


       return "redirect:baihat";
    }
    @GetMapping
    public ModelAndView showList(){
        ModelAndView mv = new ModelAndView("/list");
        List<Upload> list = uploadFileService.findAll();
        mv.addObject("uploads",list);
        return mv;
    }
}
