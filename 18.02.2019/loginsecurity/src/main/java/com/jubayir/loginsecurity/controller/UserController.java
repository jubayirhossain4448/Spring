package com.jubayir.loginsecurity.controller;

import com.jubayir.loginsecurity.entity.Role;
import com.jubayir.loginsecurity.entity.User;
import com.jubayir.loginsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role());
        roles.add(new Role());
        User user = new User("Jubayir", "jubayir", "1234",  "jubayir@gmail.com", true, roles);
        return "success";
    }
}
