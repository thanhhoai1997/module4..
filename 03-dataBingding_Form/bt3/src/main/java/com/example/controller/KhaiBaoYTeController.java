package com.example.controller;

import com.example.model.ToKhaiBaoYTe;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/khaibaoyte")
public class KhaiBaoYTeController {
    private int[] ngay = {1,2,3,4,5,6,7,8,9,10};
    private int[] thang = {1,2,3,4,5,6,7,8,9,10,11,12};
    private String[] tinh = {"Hue","Da Nang","Quang Nam"};
    private String[] quan = {"Son Tra","Lien Chieu","Hoa Khanh"};
    private String[] phuong = {"Tho Quang","An Hai Bac","An Hai Nam"};



    @GetMapping
    public ModelAndView getKhaiBaoYTe(){
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("tokhaibaoyte",new ToKhaiBaoYTe());
        List<Integer> namSinh = new ArrayList<>();
        for (int i = 1990; i <= 2023 ; i++){
            namSinh.add(i);
        }
        mv.addObject("ngay",ngay);
        mv.addObject("thang",thang);
        mv.addObject("namSinh",namSinh);
        mv.addObject("tinh",tinh);
        mv.addObject("quan",quan);
        mv.addObject("phuong",phuong);

        String[] quocTich = {"Viet Nam","Lao","Thai Lan","Cambodia","Korea","China"};
        mv.addObject("quocTich",quocTich);
        mv.addObject("phuongTienDiLai", new String[]{"Tau Bay","O To","Tau Thuyen","Khac"});
        return mv;



    }
    @PostMapping("/save")
    public ModelAndView add(@ModelAttribute("tokhaibaoyte") ToKhaiBaoYTe toKhaiBaoYTe, @Valid ToKhaiBaoYTe toKhaiBaoYTe1, BindingResult result){
        if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("form");
        }
        ModelAndView mv = new ModelAndView("form");

        mv.addObject("tokhaibaoyte",toKhaiBaoYTe);
        List<Integer> namSinh = new ArrayList<>();
        for (int i = 1990; i <= 2023 ; i++){
            namSinh.add(i);
        }
        mv.addObject("ngay",ngay);
        mv.addObject("thang",thang);
        mv.addObject("namSinh",namSinh);
        mv.addObject("tinh",tinh);
        mv.addObject("quan",quan);
        mv.addObject("phuong",phuong);

        String[] quocTich = {"Viet Nam","Lao","Thai Lan","Cambodia","Korea","China"};
        mv.addObject("quocTich",quocTich);
        mv.addObject("phuongTienDiLai", new String[]{"Tau Bay","O To","Tau Thuyen","Khac"});
        mv.addObject("message","save OK");
        return  mv;
    }

}
