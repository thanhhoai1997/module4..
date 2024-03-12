package com.example.furama.controller;

import com.example.furama.model.Facility;
import com.example.furama.model.FacilityType;
import com.example.furama.model.RentType;
import com.example.furama.model.dto.FacilityDTO;
import com.example.furama.service.facility.IFacilityService;
import com.example.furama.service.facility.IFacilityTypeService;
import com.example.furama.service.facility.IRentTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/create")
    public ModelAndView showCreate( @ModelAttribute("facility") FacilityDTO facility){
        ModelAndView mv = new ModelAndView("/facility/create");
        mv.addObject("rentTypes",iRentTypeService.findAll());
        mv.addObject("facilityTypes",iFacilityTypeService.findAll());

        return mv;
    }
    @PostMapping("/create")
    public ModelAndView showCreate(@Valid @ModelAttribute("facility") FacilityDTO facilityDTO, BindingResult bindingResult){
        new FacilityDTO().validate(facilityDTO,bindingResult);
        ModelAndView mv;
        if (bindingResult.hasErrors()){
            mv = new ModelAndView("redirect:/facility/create");
            return mv;
        }
        mv = new ModelAndView("redirect:/facility");
        RentType rentType = iRentTypeService.findById(facilityDTO.getRentType());
        FacilityType facilityType = iFacilityTypeService.findById(facilityDTO.getFacilityType());
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO,facility);
        facility.setRentType(rentType);
        facility.setFacilityType(facilityType);
        iFacilityService.save(facility);

        mv.addObject("rentTypes",iRentTypeService.findAll());
        mv.addObject("facilityTypes",iFacilityTypeService.findAll());

        return mv;
    }
    @GetMapping("")
    public  ModelAndView showList(@RequestParam("page")Optional<Integer> page,@RequestParam("name") Optional<String> name){
        ModelAndView mv = new ModelAndView("/facility/list");


        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        Page<Facility> facilities ;
        if (name.isPresent()){
            facilities = iFacilityService.findAllByName(pageable,name.get());
        }else {
            facilities = iFacilityService.findAll(pageable);
        }

        List<Integer> numberPage = new ArrayList<>();
        for (int i = 1 ; i <= facilities.getTotalPages(); i++){
            numberPage.add(i);
        }
        mv.addObject("facilities",facilities);
        mv.addObject("numberPage",numberPage);
        return mv;

    }
    @PostMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/facility");
        iFacilityService.deleteById(id);
        return mv;

    }

    @GetMapping("/edit/{id}")
    public  ModelAndView showUpdate(@PathVariable("id") Long id){
        Facility facility = iFacilityService.findById(id);
        ModelAndView mv = new ModelAndView("/facility/edit");
        mv.addObject("facility",facility);
        mv.addObject("rentTypes",iRentTypeService.findAll());
        mv.addObject("facilityTypes",iFacilityTypeService.findAll());
        return  mv;

    }
    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("facility") Facility facility){
        ModelAndView mv = new ModelAndView("redirect:/facility");
        iFacilityService.save(facility);
        return mv;

    }


}
