package com.example.restapi.Dao;

import com.example.restapi.Model.SinhvienDTO;

import java.util.List;

public interface SinhvienDAO {
    public List<SinhvienDTO> getAllSinhvien();

    List<SinhvienDTO> findSinhvienByMa(String masv);

    void addSinhvien(SinhvienDTO sv);

    void updateSinhvien(SinhvienDTO sv);

    void deleteSinhvien(String masv);

    List<SinhvienDTO> findSinhvienNuByMaLop(String maLop);
}

