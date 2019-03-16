package com.israt.carrentalproject.Controller;


import com.israt.carrentalproject.Entity.Car;
import com.israt.carrentalproject.Entity.Role;
import com.israt.carrentalproject.Repo.AgencyRepo;
import com.israt.carrentalproject.Repo.BookingRepo;
import com.israt.carrentalproject.Repo.CarRepo;
import com.israt.carrentalproject.Repo.CategoryRepo;
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
@RequestMapping(value = "/car/")
public class CarController {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private AgencyRepo agencyRepo;

//    @Autowired
//    private BookingRepo bookingRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("categorylist", categoryRepo.findAll());
        model.addAttribute("agencylist", agencyRepo.findAll());
        return "cars/add";
    }


    @PostMapping(value = "add")
    public String add(@Valid Car car, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rejectMsg", "Somthing is wrong");
            model.addAttribute("categorylist", categoryRepo.findAll());
            model.addAttribute("agencylist", agencyRepo.findAll());
            return "cars/add";
        } else {
            this.carRepo.save(car);
            model.addAttribute("car", new Car());
            model.addAttribute("successMsg", "Successfully Saved!");

            model.addAttribute("categorylist", categoryRepo.findAll());

            model.addAttribute("agencylist", agencyRepo.findAll());
        }

        return "cars/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("car", carRepo.getOne(id));

        model.addAttribute("categorylist", categoryRepo.findAll());

        model.addAttribute("agencylist", agencyRepo.findAll());
        return "cars/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Car car, BindingResult result, Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {

            model.addAttribute("categorylist", categoryRepo.findAll());
            model.addAttribute("agencylist", agencyRepo.findAll());
            return "cars/edit";
        }
        Optional<Car> car1 = this.carRepo.findByCarModel(car.getCarModel());
        if (car1.get().getId() != id) {
            model.addAttribute("rejectMsg", "Already Have This Entry");

            model.addAttribute("categorylist", categoryRepo.findAll());
            model.addAttribute("agencylist", agencyRepo.findAll());
            return "cars/edit";
        } else {
            car.setId(id);
            this.carRepo.save(car);
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("categorylist", categoryRepo.findAll());
            model.addAttribute("agencylist", agencyRepo.findAll());
        }
        return "redirect:/car/list";
    }


    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.carRepo.deleteById(id);
        }
        return "redirect:/car/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.carRepo.findAll());
        return "cars/list";
    }

}
