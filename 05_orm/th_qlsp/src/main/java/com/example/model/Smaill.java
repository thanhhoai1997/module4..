package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Smaill {
    @Id
    private int id;
    private String name;

    public Smaill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Smaill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
