package com.example.controller;

import com.example.model.Blog;
import com.example.model.BlogForm;
import com.example.model.Category;
import com.example.service.blog.IBlogService;
import com.example.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return  iCategoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showHome(@RequestParam(name = "page") Optional<Integer> page,
                                 @RequestParam("title") Optional<String> title,
                                 @RequestParam("categorySreach") Optional<String> categorySearch){
        Page<Blog> blogs ;
        List<Integer> pageSize = new ArrayList<>();
        Sort sort = Sort.by("date").descending();

        Pageable pageable = PageRequest.of(page.orElse(0),2,sort);



        if (title.isPresent()){
            blogs = iBlogService.findAllByTitle(title.get(),pageable);


        }else if (categorySearch.isPresent()){

             blogs = iBlogService.findAllByCategoryName(categorySearch.get(),pageable);


        }else {
            blogs = iBlogService.findAll(pageable);
        }


        for (int i = 1 ; i <= blogs.getTotalPages() ; i++){
            pageSize.add(i);
        }


        ModelAndView mv = new ModelAndView("index");
       mv.addObject("pageSize",pageSize);
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
        Category category = new Category();
        category.setId(blogForm.getCategory_id());
        blog.setCategory(category);
       Date date = new Date();
        blog.setDate(date);
        iBlogService.save(blog);
        ModelAndView mv = new ModelAndView("redirect:/blog");
        return mv;



    }
    @GetMapping("{id}/view")
    public ModelAndView showView(@PathVariable("id") Long id, RedirectAttributes attributes){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        attributes.addFlashAttribute("blog",iBlogService.findOne(id));
        return mv;

    }
    @GetMapping("{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
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
    public ModelAndView delete(@PathVariable("id")Long id){
        ModelAndView mv = new ModelAndView("redirect:/blog");
        iBlogService.delete(id);
        return mv;
    }
    @GetMapping("/category-layout")
    public ModelAndView returnCategories(){
        ModelAndView mv = new ModelAndView("layout");
        return mv;
    }


}
