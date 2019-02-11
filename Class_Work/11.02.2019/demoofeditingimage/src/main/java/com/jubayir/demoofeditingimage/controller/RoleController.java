package com.jubayir.demoofeditingimage.controller;

import com.jubayir.demoofeditingimage.entity.Role;
import com.jubayir.demoofeditingimage.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;


    @GetMapping("/addRole")
    public String addRole(Role role){
        return "add-role";
    }

    @PostMapping("/addRole")
    public String saveRole(@Valid Role role, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-role";
        }else {
            this.repo.save(role);
            model.addAttribute("role", new Role());
            model.addAttribute("successMsg", "Congratulation! You have done");
        }
        return "add-role";

    }

    @GetMapping("/editRole/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("role", this.repo.getOne(id));
        return "edit-role";
    }

    @PostMapping("/editRole")
    public String editRole(@Valid Role role, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if(bindingResult.hasErrors()){
            return "edit-role";
        }else {
            this.repo.save(role);
            model.addAttribute("role", new Role());
        }
        return "redirect:/";
    }

    @GetMapping(value = "/roleList")
    public String roleList(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "role-List";
    }
}
