package com.jubayir.hotelbooking.controller;

import com.jubayir.hotelbooking.entity.Booking;
import com.jubayir.hotelbooking.repository.BookingRepo;
import com.jubayir.hotelbooking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

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
        booking.setBookingTime(new Date());
        booking.setCheckIn(new Date());
        booking.setCheckout(new Date());
        this.bookingRepo.save(booking);
        model.addAttribute("successMsg", "Successfully Saved!");
        return "booking/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("booking", bookingRepo.getOne(id));
        return "booking/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Booking booking, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "booking/edit";
        }
            booking.setId(id);
            this.bookingRepo.save(booking);
        return "redirect:/booking/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.bookingRepo.deleteById(id);
        }
        return "redirect:/booking/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.bookingRepo.findAll());
        return "booking/list";
    }
}

