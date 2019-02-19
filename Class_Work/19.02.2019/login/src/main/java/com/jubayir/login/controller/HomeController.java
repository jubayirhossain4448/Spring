package com.jubayir.login.controller;

import com.jubayir.login.entity.User;
import com.jubayir.login.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/adm")
    public String adminView() {
        return "admin/admin";
    }

    @GetMapping(value = "/sa")
    public String superAdminView() {
        return "sadmin/sad";
    }

    @GetMapping(value = "/se")
    public String secureView(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        User user = userRepo.findByUserName(auth.getName());
        model.addAttribute("name", user.getName());

        return "secure/sec";
    }

    @GetMapping(value = "/u")
    public String userView() {
        return "user/u";
    }
}
