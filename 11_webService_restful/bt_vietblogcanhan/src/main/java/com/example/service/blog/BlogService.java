package com.example.service.blog;

import com.example.model.Blog;
import com.example.repositories.blog.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void delete(Long id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog findOne(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return iBlogRepository.findAllByTitle("%"+title+"%",pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryName(String s, Pageable pageable) {
        return iBlogRepository.findAllByCategoryName(s,pageable);
    }


}
