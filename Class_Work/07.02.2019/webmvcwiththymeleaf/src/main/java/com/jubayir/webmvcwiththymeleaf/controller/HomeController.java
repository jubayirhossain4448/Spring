package com.jubayir.webmvcwiththymeleaf.controller;

import com.jubayir.webmvcwiththymeleaf.entity.User;
import com.jubayir.webmvcwiththymeleaf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepo repo;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", new User());
        mv.setViewName("index");
        return mv;
    }

    @PostMapping(value = "/")
    public ModelAndView add(@Valid User user){
        ModelAndView mv = new ModelAndView();
        if (user.getName() != null){
            this.repo.save(user);
            mv.addObject("successMsg","Successfully Saved");
            mv.addObject("user", new User());
        }

        mv.setViewName("index");
        return mv;
    }


}
