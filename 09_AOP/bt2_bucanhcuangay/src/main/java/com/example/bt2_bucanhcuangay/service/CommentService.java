package com.example.bt2_bucanhcuangay.service;

import com.example.bt2_bucanhcuangay.model.Comment;
import com.example.bt2_bucanhcuangay.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository iCommentRepository;

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return iCommentRepository.findById(id).get();
    }

    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        iCommentRepository.deleteById(id);

    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return iCommentRepository.findAll(pageable);
    }
}
