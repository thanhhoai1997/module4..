package com.example.furama.service.employee;

import com.example.furama.model.EducationDegree;
import com.example.furama.repositories.employee.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements  IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
