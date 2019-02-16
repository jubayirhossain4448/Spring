package com.jubayir.springcrudeoperation.controller;

import com.jubayir.springcrudeoperation.entity.User;
import com.jubayir.springcrudeoperation.repository.UserRepository;
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
    private UserRepository repo;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping("/add")
    private String showForm(User user, Model model){
        return "add-page";
    }

    @PostMapping("/add")
    private String save(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-page";
        }
        model.addAttribute("user", new User());
        model.addAttribute("successMsg", "Congratulation You have added a new user");
        return "add-page";
    }

}
