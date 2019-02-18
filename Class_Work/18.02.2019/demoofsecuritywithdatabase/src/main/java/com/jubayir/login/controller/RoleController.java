package com.jubayir.login.controller;

import com.jubayir.login.entity.Role;
import com.jubayir.login.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
    @Autowired
    private RoleRepo repo;

    @GetMapping(value = "/role-save")
    public String saveRole(){
        Role role = new Role();
        role.setName("SUPERADMIN");
        repo.save(role);

        role.setName("ADMIN");
        repo.save(role);

        role.setName("USER");
        repo.save(role);
        System.out.println("Role successfully saved");
        return "success";
    }
}
