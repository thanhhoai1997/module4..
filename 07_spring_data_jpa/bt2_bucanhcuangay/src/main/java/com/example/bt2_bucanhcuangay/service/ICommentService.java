package com.example.bt2_bucanhcuangay.service;

import com.example.bt2_bucanhcuangay.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    Comment findById(Long id);
    void save(Comment comment);
    void deleteById(Long id);
    Page<Comment> findAll(Pageable pageable);
}
