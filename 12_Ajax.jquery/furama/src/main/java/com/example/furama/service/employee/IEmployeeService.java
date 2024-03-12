package com.example.furama.service.employee;

import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);

    Page<Employee> findAll(Pageable pageable);

    void deleteById(Long id);

    Employee findById(Long id);
    List<Employee> findAll();

    Page<Employee> findByName(Pageable pageable, String s);
}
