package com.example.furama.repositories.employee;

import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee  as e where e.name like :name")
    Page<Employee> findALlByName(Pageable pageable,@Param("name") String s);
}
