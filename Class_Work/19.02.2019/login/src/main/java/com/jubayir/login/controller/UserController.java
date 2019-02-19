package com.jubayir.login.controller;

import com.jubayir.login.entity.Role;
import com.jubayir.login.entity.User;
import com.jubayir.login.repository.UserRepo;
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
    public String saveUser() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        User user = new User("Arefin", "sadmin", passwordEncoder.encode("1234"), "arefin@gmail.com", true, roles);
        repo.save(user);


        roles.add(new Role(3L));
        User user2 = new User("Md. Jubayir", "jubayir", passwordEncoder.encode("1234"), "jubayir@gmail.com", true, roles);
        repo.save(user2);

        roles.add(new Role(2L));
        User user3 = new User("Md. Mehdee", "naim", passwordEncoder.encode("1234"), "mhd@gmail.com", true, roles);
        repo.save(user3);

        return "success";
    }

}
