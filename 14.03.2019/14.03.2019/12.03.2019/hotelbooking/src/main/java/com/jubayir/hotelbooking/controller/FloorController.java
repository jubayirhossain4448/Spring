package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Floor;
import com.jubayir.hotelbooking.repository.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/floor/")
public class FloorController {
    @Autowired
    private FloorRepo floorRepo;

    @GetMapping(value = "add")
    public String addView(Model model){
        model.addAttribute("floor", new Floor());
        return "floor/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Floor floor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "floor/add";
        }
        this.floorRepo.save(floor);
        model.addAttribute("successMsg", "Successfully Saved!");
        return "floor/add";
    }
}
