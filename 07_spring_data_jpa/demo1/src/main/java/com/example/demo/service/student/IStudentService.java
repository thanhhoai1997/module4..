package com.example.demo.service.student;

import com.example.demo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);


    Student findById(Long id);


    void remove(Long id);
}
