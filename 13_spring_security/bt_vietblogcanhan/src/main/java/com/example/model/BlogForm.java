package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Integer id;
    private String auThor;
    private String title;
    private String content;
    private MultipartFile img;
    private Long category_id;

    public BlogForm() {
    }

    public BlogForm(Integer id, String auThor, String title, String content, MultipartFile img, Long category_id) {
        this.id = id;
        this.auThor = auThor;
        this.title = title;
        this.content = content;
        this.img = img;
        this.category_id = category_id;
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

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}
