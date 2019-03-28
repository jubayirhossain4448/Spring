package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Role;
import com.jubayir.hotelbooking.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("role",new Role());
        return "roles/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Role role, BindingResult result, Model model){
        if(result.hasErrors()){
            return "roles/add";
        }
        if(repo.existsRoleByRoleName(role.getRoleName())){
            model.addAttribute("rejectMsg","Already Have This Entry");
        }else{
            role.setRoleName(role.getRoleName().toUpperCase());
            this.repo.save(role);
            model.addAttribute("role", new Role());
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "roles/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("role",repo.getOne(id));
        model.addAttribute("list", this.repo.findAll());
        return "roles/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Role role, BindingResult result, Model model,@PathVariable("id") Long id){

        if(result.hasErrors()){
            return "roles/edit";
        }
        Optional<Role> rol = this.repo.findByRoleName(role.getRoleName());
        if(rol.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "roles/edit";
        }else{
            role.setId(id);
            role.setRoleName(role.getRoleName().toUpperCase());
            this.repo.save(role);
        }
        model.addAttribute("list", this.repo.findAll());
        return "redirect:/role/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/role/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "roles/list";
    }

}
