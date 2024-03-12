package com.example.th_quanlydienthoai.controller;

import com.example.th_quanlydienthoai.model.Smartphone;
import com.example.th_quanlydienthoai.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    ISmartphoneService iSmartphoneService;
    @PostMapping
    public ResponseEntity<Smartphone> create(@RequestBody Smartphone smartphone){
        iSmartphoneService.save(smartphone);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    ResponseEntity<Smartphone> update(@RequestBody Smartphone smartphone){
        iSmartphoneService.save(smartphone);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/list")
    public ModelAndView showList(@RequestParam("page")Optional<Integer> page){
        ModelAndView mv = new ModelAndView("/phones/list");
        Sort sort = Sort.by("producer").ascending();
        Pageable pageable = PageRequest.of(page.orElse(0),3,sort);
        mv.addObject("smartphones",iSmartphoneService.findAll(pageable));
        return mv;

    }
    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> findAll(){
        return  new ResponseEntity<>(iSmartphoneService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Smartphone> deleteSmartPhone(@PathVariable("id") Long id){
        Smartphone smartphone = iSmartphoneService.findById(id);
        iSmartphoneService.deleteById(id);
        return  new ResponseEntity<>(smartphone,HttpStatus.NO_CONTENT);
    }
}
