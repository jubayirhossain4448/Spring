package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Booking;
import com.jubayir.hotelbooking.repository.BookingRepo;
import com.jubayir.hotelbooking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/booking/")
public class BookingController {
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserRepo repo;

    @GetMapping(value = "add")
    public String addView(Model model){
        model.addAttribute("booking", new Booking());
        return "booking/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Booking booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "booking/add";
        }
        this.bookingRepo.save(booking);
        model.addAttribute("successMsg", "Successfully Saved!");
        return "booking/add";
    }
}

