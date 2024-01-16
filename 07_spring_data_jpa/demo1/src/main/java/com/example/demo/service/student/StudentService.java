package com.example.demo.service.student;

import com.example.demo.model.Student;
import com.example.demo.repositories.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return iStudentRepository.getById(id);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.delete(findById(id));
    }
}
