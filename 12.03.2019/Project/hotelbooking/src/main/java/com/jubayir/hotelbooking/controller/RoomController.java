package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Room;
import com.jubayir.hotelbooking.repository.FloorRepo;
import com.jubayir.hotelbooking.repository.RoomRepo;
import com.jubayir.hotelbooking.repository.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/room/")
public class RoomController {
    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private FloorRepo floorRepo;

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    @GetMapping(value = "add")
    public String addView(Model model){
        model.addAttribute("room", new Room());
        return "room/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "room/add";
        }
        this.roomRepo.save(room);
        model.addAttribute("successMsg", "Successfully Saved!");
        return "room/add";
    }
}
