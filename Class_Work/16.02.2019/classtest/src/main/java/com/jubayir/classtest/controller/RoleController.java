package com.jubayir.classtest.controller;

import com.jubayir.classtest.entity.Role;
import com.jubayir.classtest.repository.RoleRepo;
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
    private RoleRepo repos;

    @GetMapping("/role")
    public String showRole(Model model){
        model.addAttribute("list", this.repos.findAll());
        return "role-index";
    }

    @GetMapping("/addRole")
    public String showForm(Role role){
        return "add-role";
    }

    @PostMapping("/addRole")
    public String save(@Valid Role role, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "add-role";
        }
        this.repos.save(role);
        model.addAttribute("role", new Role());
        model.addAttribute("successMsg", "Congratulation you have added a Role");
        return "add-role";
    }


    @GetMapping("/editRole/{id}")
    public String editView(@PathVariable("id") Long id, Model model){
        model.addAttribute("role", this.repos.getOne(id));
        return "edit-role";
    }

    @PostMapping("/editRole/{id}")
    public String edit(@Valid Role role, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        if (bindingResult.hasErrors()){
            return "edit-role";
        }
        this.repos.save(role);
        model.addAttribute("role", new Role());
        return "redirect:/role";
    }

    @GetMapping(value = "/deleteRole/{id}")
    public String delete(@PathVariable("id") Long id){
        if (id != null){
            this.repos.deleteById(id);
        }
        return "redirect:/role";
    }


}
