package com.jubayir.exampleofeditingimage.controller;

import com.jubayir.exampleofeditingimage.entity.Student;
import com.jubayir.exampleofeditingimage.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping
    public String index(Model model){
        model.addAttribute("student", new Student());
        return "index";
    }
}
