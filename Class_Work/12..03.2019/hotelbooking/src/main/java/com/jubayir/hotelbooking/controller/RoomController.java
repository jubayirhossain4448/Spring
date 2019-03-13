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
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("floorList", this.floorRepo.findAll());
        model.addAttribute("roomTypelist", this.roomTypeRepo.findAll());
        return "room/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "room/add";
        }
        this.roomRepo.save(room);
        model.addAttribute("floorList", this.floorRepo.findAll());
        model.addAttribute("roomTypeList", this.roomTypeRepo.findAll());
        model.addAttribute("successMsg", "Successfully Saved!");
        return "room/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("room", roomRepo.getOne(id));
        return "room/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Room room, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "room/edit";
        }
            room.setId(id);
            this.roomRepo.save(room);


        return "redirect:/room/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.roomRepo.deleteById(id);
        }
        return "redirect:/room/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.roomRepo.findAll());
        return "room/list";
    }
}
