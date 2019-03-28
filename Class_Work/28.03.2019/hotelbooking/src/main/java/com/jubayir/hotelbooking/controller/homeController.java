package com.jubayir.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping(value = "/")
    public String display(){
        return "dashboard";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

    @GetMapping(value = "/post")
    public String post(){
        return "quickpost";
    }


    @GetMapping(value = "/loginF")
    public String login(){
        return "loginF";
    }

//    @GetMapping(value = "/login")
//    public String loginView(){
//        return "login";
//    }
//
//    @GetMapping(value = "/userlist")
//    public String userList(){
//        return "userlist";
//    }
}
