package com.example.furama.service.employee;

import com.example.furama.model.Division;
import com.example.furama.repositories.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements  IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
