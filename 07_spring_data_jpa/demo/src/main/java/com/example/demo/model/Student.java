package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private CodegymClass codegymClass;

    public Student() {
    }

    public Student(Long id, String name, String email, CodegymClass codegymClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.codegymClass = codegymClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CodegymClass getCodegymClass() {
        return codegymClass;
    }

    public void setCodegymClass(CodegymClass codegymClass) {
        this.codegymClass = codegymClass;
    }
}
