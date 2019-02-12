package com.jubayir.demoofeditingimage.controller;

import com.jubayir.demoofeditingimage.entity.Role;
import com.jubayir.demoofeditingimage.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo repo;


    @GetMapping(value = "/addRole")
    public String addRoleView(Role role) {
        return "add-role";
    }

    @PostMapping(value = "/addRole")
    public String addRole(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-role";
        } else {
            if (role != null) {
                Role role1 = this.repo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "RoleName is already exist!");
                } else {
                    this.repo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successMsg", "Congratulation! You have done");
                }
            }

        }
        return "add-role";
    }

    @GetMapping("/editRole/{id}")
    public String editRoleView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("role", this.repo.getOne(id));
        return "edit-role";
    }

    @PostMapping("/editRole/{id}")
    public String editRole(@Valid Role role, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit-role";
        } else {
            if (role != null) {
                Role role1 = this.repo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("existMsg", "Role Name is already exist");
                    return "edit-role";
                } else {
                    this.repo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("successMsg", "Successfully created!");
                }
            }

        }
        return "redirect:/roleList";
    }

    @GetMapping(value = "/roleList")
    public String roleList(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "role-List";
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.GET)
    public String delRole(@PathVariable("id") Long id) {
        this.repo.deleteById(id);
        return "redirect:/roleList";
    }

}
