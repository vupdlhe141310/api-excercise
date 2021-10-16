package com.example.restapi.Service.ServiceImpl;

import com.example.restapi.Dao.SinhvienDAO;
import com.example.restapi.Model.SinhvienDTO;
import com.example.restapi.Service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SinhvienServiceImpl implements SinhvienService {

    @Autowired
    private SinhvienDAO sinhvienDAO;

    @Override
    public List<SinhvienDTO> getAllSinhvien() {
        return sinhvienDAO.getAllSinhvien();
    }

    @Override
    public List<SinhvienDTO> findSinhvienByMa(String masv) {
        if(masv == ""){
            return sinhvienDAO.getAllSinhvien();
        }
        return sinhvienDAO.findSinhvienByMa(masv);
    }

    @Override
    public void addSinhvien(SinhvienDTO sv) {
        sinhvienDAO.addSinhvien(sv);
    }

    @Override
    public void updateSinhvien(SinhvienDTO sv) {
        sinhvienDAO.updateSinhvien(sv);
    }

    @Override
    public void deleteSinhvien(String masv) {
        sinhvienDAO.deleteSinhvien(masv);
    }

    @Override
    public List<SinhvienDTO> findSinhvienNuByMaLop(String maLop) {
        return sinhvienDAO.findSinhvienNuByMaLop(maLop);
    }

}
