package com.example.bt2_bucanhcuangay.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int mark;
    private String auThor;

    private String feedBack;
    private Date timeComment;

    public Comment() {
    }

    public Comment(Long id, int mark, String auThor, String feedBack, Date timeComment) {
        this.id = id;
        this.mark = mark;
        this.auThor = auThor;
        this.feedBack = feedBack;
        this.timeComment = timeComment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuThor() {
        return auThor;
    }

    public void setAuThor(String auThor) {
        this.auThor = auThor;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }
}
