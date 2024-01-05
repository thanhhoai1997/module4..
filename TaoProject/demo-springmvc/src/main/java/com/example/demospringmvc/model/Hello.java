package com.example.demospringmvc.model;

import org.springframework.context.annotation.Bean;


public class Hello {

    private String name;

    public Hello() {
    }

    public Hello(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
