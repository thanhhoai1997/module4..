package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Integer id;
    private String auThor;
    private String title;
    private String content;
    private MultipartFile img;

    public BlogForm() {
    }

    public BlogForm(Integer id, String auThor, String title, String content, MultipartFile img) {
        this.id = id;
        this.auThor = auThor;
        this.title = title;
        this.content = content;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuThor() {
        return auThor;
    }

    public void setAuThor(String auThor) {
        this.auThor = auThor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
