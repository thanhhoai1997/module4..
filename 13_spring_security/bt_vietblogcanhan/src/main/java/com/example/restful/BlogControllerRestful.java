package com.example.restful;

import com.example.model.Blog;
import com.example.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class BlogControllerRestful {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public List<Blog> findAll(){
        List<Blog> blogs = iBlogService.findAll();
        return blogs;
    }
    @PostMapping("")
    public Blog create(@RequestBody Blog blog){
        iBlogService.save(blog);
        return blog;
    }
    @PutMapping("")
    public void update(@RequestBody Blog blog){
        iBlogService.save(blog);
    }
    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id){
        iBlogService.delete(id);
    }
}
