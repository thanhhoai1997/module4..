package com.example.th_validating_form.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
    @NotEmpty(message = "khong duoc de trong")
    @Size(min = 2, max = 30 , message = "do dai tu 2-30 ki tu")
    private String name;
    @Min(value = 18, message = "tuoi phai lon hon 18")
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
