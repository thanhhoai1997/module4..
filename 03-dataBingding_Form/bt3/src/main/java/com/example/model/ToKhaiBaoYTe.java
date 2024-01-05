package com.example.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ToKhaiBaoYTe {
    @NotBlank(message = "khong the de trong")
    private String hoTen;
    private int namSinh;
    private boolean gioiTinh;
    private String quocTich;
    private String soCMND;
    private String phuongTien;
    private String soHieuPhuongTien;
    private String soGhe;
    private Date ngayKhoiHanh;

    private Date ngayKetThuc;
    private String ghiChu;
    private String tinh;
    private String quan;
    private String phuong;
    private String diaChiNoiO;
    private String soDienThoai;
    private String email;
   private boolean sot;
    private boolean ho;
    private boolean khoTho;
    private boolean dauHong;
    private boolean buonNon;
    private boolean tieuChay;
    private boolean xuatHuyetNgoaiDa;
    private boolean noiBanNgoaiDa;
    private boolean lichSuPhoiNhiem1;
    private boolean lichSuPhoiNhiem2;


    public ToKhaiBaoYTe(String hoTen, int namSinh, boolean gioiTinh, String quocTich, String soCMND, String phuongTien, String soHieuPhuongTien, String soGhe, Date ngayKhoiHanh, Date ngayKetThuc, String ghiChu, String tinh, String quan, String phuong, String diaChiNoiO, String soDienThoai, String email, boolean sot, boolean ho, boolean khoTho, boolean dauHong, boolean buonNon, boolean tieuChay, boolean xuatHuyetNgoaiDa, boolean noiBanNgoaiDa, boolean lichSuPhoiNhiem1, boolean lichSuPhoiNhiem2) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.soCMND = soCMND;
        this.phuongTien = phuongTien;
        this.soHieuPhuongTien = soHieuPhuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.ghiChu = ghiChu;
        this.tinh = tinh;
        this.quan = quan;
        this.phuong = phuong;
        this.diaChiNoiO = diaChiNoiO;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.buonNon = buonNon;
        this.tieuChay = tieuChay;
        this.xuatHuyetNgoaiDa = xuatHuyetNgoaiDa;
        this.noiBanNgoaiDa = noiBanNgoaiDa;
        this.lichSuPhoiNhiem1 = lichSuPhoiNhiem1;
        this.lichSuPhoiNhiem2 = lichSuPhoiNhiem2;
    }

    public ToKhaiBaoYTe() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public Date getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(Date ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getDiaChiNoiO() {
        return diaChiNoiO;
    }

    public void setDiaChiNoiO(String diaChiNoiO) {
        this.diaChiNoiO = diaChiNoiO;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSot() {
        return sot;
    }

    public void setSot(boolean sot) {
        this.sot = sot;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKhoTho() {
        return khoTho;
    }

    public void setKhoTho(boolean khoTho) {
        this.khoTho = khoTho;
    }

    public boolean isDauHong() {
        return dauHong;
    }

    public void setDauHong(boolean dauHong) {
        this.dauHong = dauHong;
    }

    public boolean isBuonNon() {
        return buonNon;
    }

    public void setBuonNon(boolean buonNon) {
        this.buonNon = buonNon;
    }

    public boolean isTieuChay() {
        return tieuChay;
    }

    public void setTieuChay(boolean tieuChay) {
        this.tieuChay = tieuChay;
    }

    public boolean isXuatHuyetNgoaiDa() {
        return xuatHuyetNgoaiDa;
    }

    public void setXuatHuyetNgoaiDa(boolean xuatHuyetNgoaiDa) {
        this.xuatHuyetNgoaiDa = xuatHuyetNgoaiDa;
    }

    public boolean isNoiBanNgoaiDa() {
        return noiBanNgoaiDa;
    }

    public void setNoiBanNgoaiDa(boolean noiBanNgoaiDa) {
        this.noiBanNgoaiDa = noiBanNgoaiDa;
    }

    public boolean isLichSuPhoiNhiem1() {
        return lichSuPhoiNhiem1;
    }

    public void setLichSuPhoiNhiem1(boolean lichSuPhoiNhiem1) {
        this.lichSuPhoiNhiem1 = lichSuPhoiNhiem1;
    }

    public boolean isLichSuPhoiNhiem2() {
        return lichSuPhoiNhiem2;
    }

    public void setLichSuPhoiNhiem2(boolean lichSuPhoiNhiem2) {
        this.lichSuPhoiNhiem2 = lichSuPhoiNhiem2;
    }
}
