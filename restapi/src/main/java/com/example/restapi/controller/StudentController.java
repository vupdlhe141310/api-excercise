package com.example.restapi.controller;

import com.example.restapi.model.SinhvienDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class StudentController {
    private List<SinhvienDTO> students = new ArrayList<>();

    @GetMapping("/dssv")
    public List<SinhvienDTO> getAllStudent(){
        students.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getTen())));
        return students;
    }

    @GetMapping("/getsv")
    public SinhvienDTO getStudentByMasv(@RequestParam("masv") String masv){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getMasv().equalsIgnoreCase(masv)){
                return students.get(i);
            }
        }
        return null;
    }
    @PostMapping("/sv")
    public SinhvienDTO addStudent(@RequestBody SinhvienDTO sv){
        students.add(sv);
        return sv;
    }

    @DeleteMapping("/sv")
    public SinhvienDTO deleteStudent(@RequestParam("masv") String masv){
        SinhvienDTO svDel = new SinhvienDTO();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getMasv().equalsIgnoreCase(masv)){
                svDel = students.get(i);
                students.remove(i);
            }
        }
        return  svDel;
    }

    @PutMapping("sv")
    public SinhvienDTO updateStudent(@RequestBody SinhvienDTO sv){
        SinhvienDTO svUd = new SinhvienDTO();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getMasv().equalsIgnoreCase(sv.getMasv())){
                svUd = students.get(i);
                students.set(i,sv);
            }
        }
        return svUd;
    }

    @GetMapping("/getsvnu")
    public List<SinhvienDTO> getSvNuByLop(@RequestParam("maLop") String maLop){
        students.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getHoDem()).thenComparing(sv -> ((SinhvienDTO)sv).getTen())));
        List<SinhvienDTO> listSvNu = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getMaLop().equalsIgnoreCase(maLop) && students.get(i).getGioiTinh().equalsIgnoreCase("nu")){
                listSvNu.add(students.get(i));
            }
        }
        return listSvNu;
    }

}
