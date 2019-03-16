package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.RoomType;
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
import java.util.Optional;

@Controller
@RequestMapping(value = "/roomType/")
public class RoomTypeController {
    @Autowired
    private RoomTypeRepo typeRepo;

    @GetMapping(value = "add")
    public String addView(Model model){
        model.addAttribute("roomType", new RoomType());
        return "roomType/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid RoomType roomType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "roomType/add";
        }
            this.typeRepo.save(roomType);
            model.addAttribute("successMsg", "Successfully Saved!");
        return "roomType/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roomType", typeRepo.getOne(id));
        return "roomType/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid RoomType roomType, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "roomType/edit";
        }
            roomType.setId(id);
            this.typeRepo.save(roomType);

        return "redirect:/roomType/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.typeRepo.deleteById(id);
        }
        return "redirect:/roomType/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.typeRepo.findAll());
        return "roomType/list";
    }
}
