package com.example.restapi.model;

import java.util.Date;

public class SinhvienDTO {

    private String masv;
    private String hoDem;
    private String ten;
    private String gioiTinh;
    private Date ngaySinh;
    private String tinh;
    private String maLop;

    public String getMaLop() {
        return this.maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMasv() {
        return this.masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHoDem() {
        return this.hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTinh() {
        return this.tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }
}
