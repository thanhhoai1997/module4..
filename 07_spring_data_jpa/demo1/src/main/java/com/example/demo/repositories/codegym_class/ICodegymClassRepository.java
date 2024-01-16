package com.example.demo.repositories.codegym_class;

import com.example.demo.model.CodegymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodegymClassRepository extends JpaRepository<CodegymClass,Long> {
}
