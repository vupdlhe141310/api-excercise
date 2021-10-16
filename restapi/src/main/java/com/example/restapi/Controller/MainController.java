package com.example.restapi.Controller;

import com.example.restapi.Model.SinhvienDTO;
import com.example.restapi.Service.SinhvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private SinhvienService sinhvienService;


    @GetMapping(value = "/")
    public String sinhvien(Model model){
        List<SinhvienDTO> listSinhvien = sinhvienService.getAllSinhvien();
        listSinhvien.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getTen())));
        for (SinhvienDTO sv :listSinhvien) {
            System.out.println(sv);
        }
        model.addAttribute("listSinhvien",listSinhvien);
        return "index";
    }
    @GetMapping(value = "/search")
    public String search(@Param("masv") String masv,Model model){

        List<SinhvienDTO> listSinhvien = sinhvienService.findSinhvienByMa(masv);
        System.out.println(masv);

        model.addAttribute("listSinhvien",listSinhvien);
        return "index";
    }

    @GetMapping(value = "/edit")
    public String editSV(@RequestParam("masv") String masv, Model model){
        Optional<SinhvienDTO> svEdit = Optional.ofNullable(sinhvienService.findSinhvienByMa(masv).get(0));
        svEdit.ifPresent(sv -> model.addAttribute("sv",sv));
        return "editSinhvien";
    }
    @PutMapping(value = "updateSinhvien")
    public String saveUpdate(@ModelAttribute SinhvienDTO sv, BindingResult bindingResult, RedirectAttributes model){
        System.out.println(sv);

        if(bindingResult.hasErrors()){
            return "addSinhvien";
        }else{
            sinhvienService.updateSinhvien(sv);
            model.addFlashAttribute("success", "Cập nhật thành công!");
            System.out.println("Thanh cong");
            return "redirect:/";
        }
    }
    @GetMapping(value = "/add")
    public String addSV(Model model){
        model.addAttribute("sv",new SinhvienDTO());
        return "addSinhvien";
    }

    @PostMapping(value = "addSinhvien")
    public String addSinhvien(@ModelAttribute SinhvienDTO sv, BindingResult bindingResult, RedirectAttributes model){
        System.out.println(sv);

        if(bindingResult.hasErrors()){
            return "redirect:/";
        }else{
            sinhvienService.addSinhvien(sv);
            return "redirect:/";
        }
    }
    @GetMapping(value = "/delete")
    public String deleteSV(@RequestParam("masv") String masv, RedirectAttributes model){
        sinhvienService.deleteSinhvien(masv);
        model.addFlashAttribute("success","Xóa thành công!");
        return "redirect:/";
    }

    @GetMapping(value = "/findFM")
    public String findFM(@Param("maLop") String maLop,Model model){

        List<SinhvienDTO> listSinhvien = sinhvienService.findSinhvienNuByMaLop(maLop);
        System.out.println(maLop);

        listSinhvien.sort((Comparator.comparing(sv -> ((SinhvienDTO)sv).getHoDem()).thenComparing(sv -> ((SinhvienDTO)sv).getTen())));
        model.addAttribute("listSinhvien",listSinhvien);
        return "index";
    }

}
