package com.jubayir.studentinfo.controller;

import com.jubayir.studentinfo.entity.Student;
import com.jubayir.studentinfo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        this.repo.findAll().forEach((c) ->{
            System.out.println(c.toString());
        });
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Student user){
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-message" +
                    "";
        }
        return "add-message";
    }
}
