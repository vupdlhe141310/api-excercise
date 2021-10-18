package com.example.restapi.Controller;

import com.example.restapi.Model.SinhvienDTO;
import com.example.restapi.Service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class SinhvienController {

    @Autowired
    private SinhvienService sinhvienService;

    @GetMapping("/dssv")
    public List<SinhvienDTO> getAllStudent(){
        private List<SinhvienDTO> students = sinhvienService.getAllSinhvien();
        students.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getTen())));
        return students;
    }

    @GetMapping("/getsv")
    public SinhvienDTO getStudentByMasv(@RequestParam("masv") String masv){
        private List<SinhvienDTO> students = sinhvienService.getAllSinhvien();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getMasv().equalsIgnoreCase(masv)){
                return students.get(i);
            }
        }
        return null;
    }
    @PostMapping("/sv")
    public SinhvienDTO addStudent(@RequestBody SinhvienDTO sv){
        sinhvienService.addSinhvien(sv);
        return sv;
    }

    @DeleteMapping("/sv")
    public SinhvienDTO deleteStudent(@RequestParam("masv") String masv){
        SinhvienDTO svDel = new SinhvienDTO();
        sinhvienService.deleteSinhvien(masv);
        return  svDel;
    }

    @PutMapping("sv")
    public SinhvienDTO updateStudent(@RequestBody SinhvienDTO sv){
        SinhvienDTO svUd = new SinhvienDTO();
        sinhvienService.updateSinhvien(sv);
        return svUd;
    }

    @GetMapping("/getsvnu")
    public List<SinhvienDTO> getSvNuByLop(@RequestParam("maLop") String maLop){
        private List<SinhvienDTO> students = sinhvienService.getAllSinhvien();
        students.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getHoDem()).thenComparing(sv -> ((SinhvienDTO)sv).getTen())));

        return students;
    }

}
