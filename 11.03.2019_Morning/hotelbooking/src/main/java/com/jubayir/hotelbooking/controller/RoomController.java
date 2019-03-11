package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Room;
import com.jubayir.hotelbooking.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    private RoomRepo roomRepo;

    @GetMapping(value = "add")
    public String addView(Model model) {
        model.addAttribute("room", new Room());
        return "users/add";
    }


}
