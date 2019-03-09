package com.jubayir.templateadding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String displayHome()
    {
        return "layout";
    }

    @GetMapping(value = "/about")
    public String aboutView(){
        return "about";
    }


}
