package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Hotel;
import com.jubayir.hotelbooking.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/hotel/")
public class HotelController {
    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping(value = "add")
    public String addView(Model model){
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


}
