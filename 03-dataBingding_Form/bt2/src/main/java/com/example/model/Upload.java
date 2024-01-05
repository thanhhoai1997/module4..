package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    private String tenBaiHat;
    private String ngheSi;
    private String[] theLoai;
    private MultipartFile file;

    public Upload() {
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String[] getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String[] theLoai) {
        this.theLoai = theLoai;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
