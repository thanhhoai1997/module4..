package com.example.service;

import com.example.model.Blog;
import com.example.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
            iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
    iBlogRepository.delete(id);
    }

    @Override
    public Blog findOne(int id) {
      return   iBlogRepository.findOne(id);
    }
}
