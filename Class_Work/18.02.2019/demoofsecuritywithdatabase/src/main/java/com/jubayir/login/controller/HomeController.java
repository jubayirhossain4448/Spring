package com.jubayir.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/u")
    public String user(){
        return "user/u";
    }

    @GetMapping(value = "/se")
    public String secure(){
        return "secure/sec";
    }

    @GetMapping(value = "/adm")
    public String adminView(){
        return "admin/sad";
    }

    @GetMapping(value = "/sa")
    public String superAdmin(){
        return "sadmin/sad";
    }
}
