package com.example.demo.service.codegym_class;

import com.example.demo.model.CodegymClass;
import com.example.demo.repositories.codegym_class.ICodegymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodegymClassService implements  ICodegymClassService{
    @Autowired
    private ICodegymClassRepository iCodegymClassRepository;
    @Override
    public List<CodegymClass> findAll() {
        return iCodegymClassRepository.findAll();
    }
}
