package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Hotel;
import com.jubayir.hotelbooking.entity.Role;
import com.jubayir.hotelbooking.repository.HotelRepo;
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
@RequestMapping(value = "/hotel/")
public class HotelController {
    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping(value = "add")
    public String addView(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotel/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Hotel hotel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "hotel/add";
        }
        this.hotelRepo.save(hotel);
        model.addAttribute("successMsg", "Successfully Saved!");
        return "hotel/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("hotel", hotelRepo.getOne(id));
        return "hotel/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Hotel hotel, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "hotel/edit";
        }
        hotel.setId(id);
        this.hotelRepo.save(hotel);

        return "redirect:/hotel/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.hotelRepo.deleteById(id);
        }
        return "redirect:/hotel/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.hotelRepo.findAll());
        return "hotel/list";
    }
}
