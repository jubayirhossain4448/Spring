package com.jubayir.classtest.controller;

import com.jubayir.classtest.entity.User;
import com.jubayir.classtest.repository.RoleRepo;
import com.jubayir.classtest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo repos;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "index";
    }

    @GetMapping("/add")
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
        model.addAttribute("successMsg", "Congratulation you have added a user");
        return "add-page";
    }

    @GetMapping("/edit/{id}")
    public String editView(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", this.repo.getOne(id));
        return "edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit-page";
        }
        this.repo.save(user);
        model.addAttribute("user", new User());
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        if (id != null){
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }
}
