package com.jubayir.login.controller;

import com.jubayir.login.entity.Role;
import com.jubayir.login.entity.User;
import com.jubayir.login.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("USER"));
        User user = new User("Jubayir", "25", "jubayir@gmail.com", "Java", "Male", "37", "1234");
        repo.save(user);

    }
}
