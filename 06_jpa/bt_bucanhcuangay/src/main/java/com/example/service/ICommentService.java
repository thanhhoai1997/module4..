package com.example.service;

import com.example.model.Comment;

import java.util.List;

public interface ICommentService {
    void save(Comment comment);
    List<Comment> findAll();
}
