package com.example.repositories;

import com.example.model.Comment;

import java.util.List;

public interface ICommentRepository {
    void save(Comment comment);
    List<Comment> findAll();
}
