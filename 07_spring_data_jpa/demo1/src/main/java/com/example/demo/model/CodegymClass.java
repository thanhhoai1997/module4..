package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class CodegymClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String name;

    public CodegymClass(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CodegymClass() {
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
}
