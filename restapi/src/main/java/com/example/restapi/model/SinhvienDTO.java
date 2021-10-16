package com.example.restapi.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhvienDTO {

    private String masv;
    private String hoDem;
    private String ten;
    private String gioiTinh;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    public void setNgaySinh(String ngaySinhs) throws ParseException {
        this.ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinhs);
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

    @Override
    public String toString() {
        return "SinhvienDTO{" +
                "masv='" + masv + '\'' +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", tinh='" + tinh + '\'' +
                ", maLop='" + maLop + '\'' +
                '}';
    }
}
