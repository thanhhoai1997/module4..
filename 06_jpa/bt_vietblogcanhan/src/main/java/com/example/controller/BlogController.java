package com.example.controller;

import com.example.model.Blog;
import com.example.model.BlogForm;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public ModelAndView showHome(){
       List<Blog> blogs = iBlogService.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("blogs",blogs);
return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("blogForm")BlogForm blogForm){
        ModelAndView mv = new ModelAndView("create");
        return mv;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("blogForm") BlogForm blogForm){
        MultipartFile multipartFile = blogForm.getImg();
        String filename = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(blogForm.getImg().getBytes(), new File(fileUpload + filename) );


        }catch (IOException e){
            e.printStackTrace();
        }
        Blog blog = new Blog();
        blog.setAuThor(blogForm.getAuThor());
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());
        blog.setImg(filename);
        iBlogService.save(blog);
        ModelAndView mv = new ModelAndView("redirect:/blog");
        return mv;



    }
    @GetMapping("{id}/view")
    public ModelAndView showView(@PathVariable("id") int id, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        attributes.addFlashAttribute("blog",iBlogService.findOne(id));
        return mv;

    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.addObject("blog",iBlogService.findOne(id));
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("blog") Blog blog,RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iBlogService.save(blog);
        attributes.addFlashAttribute("blog",blog);
        return mv;
    }
    @GetMapping("{id}/delete")
    public ModelAndView delete(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iBlogService.delete(id);
        return mv;
    }

}
