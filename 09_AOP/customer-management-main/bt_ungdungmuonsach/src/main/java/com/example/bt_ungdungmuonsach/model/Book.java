package com.example.bt_ungdungmuonsach.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer quantity;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "book")
    private List<BookCode> bookCodes;

    public Book() {
    }

    public Book(Long id, String name, String author, Integer quantity, Category category, List<BookCode> bookCodes) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
        this.bookCodes = bookCodes;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<BookCode> getBookCodes() {
        return bookCodes;
    }

    public void setBookCodes(List<BookCode> bookCodes) {
        this.bookCodes = bookCodes;
    }
}
