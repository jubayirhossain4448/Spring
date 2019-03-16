package com.israt.carrentalproject.Controller;

import com.israt.carrentalproject.Entity.Role;

import com.israt.carrentalproject.Repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
            model.addAttribute("role",new Role());
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "roles/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("role",repo.getOne(id));
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

//    @GetMapping(value = "/role-save")
//    public String saveRole(){
//        Role role=new Role();
//        role.setRoleName("SUPERADMIN");
//        repo.save(role);
//
//        Role role2=new Role();
//        role2.setRoleName("ADMIN");
//        repo.save(role2);
//
//        Role role3=new Role();
//        role3.setRoleName("USER");
//        repo.save(role3);
//
//        return "success";
//    }
