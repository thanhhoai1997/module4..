package com.example.furama.service.employee;

import com.example.furama.model.Employee;
import com.example.furama.repositories.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findByName(Pageable pageable, String s) {
        return iEmployeeRepository.findALlByName(pageable,"%" + s + "%");
    }
}
