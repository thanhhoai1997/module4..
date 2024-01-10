package com.example.service;

import com.example.model.Comment;
import com.example.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRepository iCommentRepository;
    @Override
    public void save(Comment comment) {
        iCommentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return iCommentRepository.findAll();
    }
}
