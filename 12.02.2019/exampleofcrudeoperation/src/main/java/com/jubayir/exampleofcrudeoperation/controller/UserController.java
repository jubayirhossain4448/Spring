package com.jubayir.exampleofcrudeoperation.controller;

import com.jubayir.exampleofcrudeoperation.entity.User;
import com.jubayir.exampleofcrudeoperation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String showForm(User user){
        return "add-page";
    }

    @PostMapping("/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-page";
        }
        this.repo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("successMsg", "Congratulation You have added User Successfully");
        return "add-page";
    }
}
