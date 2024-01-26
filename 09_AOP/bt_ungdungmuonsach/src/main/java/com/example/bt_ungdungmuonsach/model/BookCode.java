package com.example.bt_ungdungmuonsach.model;

import jakarta.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int code;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookCode() {
    }

    public BookCode(Long id, int code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
