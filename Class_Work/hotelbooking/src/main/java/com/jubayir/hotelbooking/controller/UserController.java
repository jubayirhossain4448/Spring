package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.User;
import com.jubayir.hotelbooking.repository.UserRepo;
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
    UserRepo userRepo;

    @GetMapping(value = "/add")
    public String add(User user, Model model) {
        return "users/add-user";
    }

    @PostMapping(value = "/add")
    public String save(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "users/add-user";
        }
        model.addAttribute("user", new User());
        model.addAttribute("successMsg", "Congratulation You have added a user name");
        return "users/add-user";
    }
}
