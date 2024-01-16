package com.example.th_qlkh_tinh.controller;

import com.example.th_qlkh_tinh.model.Province;
import com.example.th_qlkh_tinh.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;
    @GetMapping("")
    public ModelAndView showProvince(@RequestParam("page")Optional<Integer> page,
                                     @RequestParam("search")Optional<String> search){

        Pageable pageable = PageRequest.of(page.orElse(0),3);
        Page<Province> provinces ;
        if (search.isPresent()){
            provinces = iProvinceService.findAllByNameContaining(search.get(),pageable);
        }else {
            provinces = iProvinceService.findAll(pageable);
        }
        ModelAndView mv = new ModelAndView("/province/list");

        mv.addObject("provinces",provinces);
        return mv;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("province") Province province){
        ModelAndView mv = new ModelAndView("/province/create");
        return mv;

    }
    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("province") Province province){
        ModelAndView mv = new ModelAndView("redirect:/province");
        iProvinceService.save(province);
        return mv;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("/province/edit");
       Optional<Province> province = iProvinceService.findById(id);
        mv.addObject("province",province.get());
        return mv;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("province") Province province){
        ModelAndView mv = new ModelAndView("redirect:/province");
        iProvinceService.save(province);
        return mv;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id){
        Optional<Province> province = iProvinceService.findById(id);

        ModelAndView mv = new ModelAndView("/province/delete");
        mv.addObject("province",province.get());
        return mv;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("province") Province province){
        ModelAndView mv = new ModelAndView("redirect:/province");
        iProvinceService.remote(province.getId());
        return mv;
    }
}
