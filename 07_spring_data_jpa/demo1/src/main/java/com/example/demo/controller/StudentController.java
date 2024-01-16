package com.example.demo.controller;

import com.example.demo.model.CodegymClass;
import com.example.demo.model.Student;
import com.example.demo.service.codegym_class.ICodegymClassService;
import com.example.demo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @Autowired
    private ICodegymClassService iCodegymClassService;

    @ModelAttribute("CodegymClass")
    public List<CodegymClass> findAll() {
        return iCodegymClassService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showList() {
        ModelAndView mv = new ModelAndView("/list");
        mv.addObject("students", iStudentService.findAll());
        return mv;

    }

    @GetMapping("/create")
    public ModelAndView showCreate(@ModelAttribute("student") Student student) {
        ModelAndView mv = new ModelAndView("/create");
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView save(@ModelAttribute("student") Student student) {
        ModelAndView mv = new ModelAndView("redirect:/student/");
        iStudentService.save(student);
        return mv;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("/edit");
        Student student = iStudentService.findById(id);
        mv.addObject("student", student);
        return mv;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute("student") Student student) {
        ModelAndView mv = new ModelAndView("redirect:/student/");
        iStudentService.save(student);
        return mv;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("redirect:/student/");
        iStudentService.remove(id);
        return mv;
    }
}
