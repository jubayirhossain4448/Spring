package com.jubayir.studentlist.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "Hello MVC";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Hello Test";
    }

    public Student addStudent(){

    }
}
