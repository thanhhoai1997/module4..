package com.example.bt2_bucanhcuangay.repositories;

import com.example.bt2_bucanhcuangay.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICommentRepository extends JpaRepository<Comment,Long> {

}
