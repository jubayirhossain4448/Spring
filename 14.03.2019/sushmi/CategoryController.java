package com.israt.carrentalproject.Controller;


import com.israt.carrentalproject.Entity.Category;
import com.israt.carrentalproject.Entity.Role;
import com.israt.carrentalproject.Repo.CategoryRepo;
import com.israt.carrentalproject.Repo.RoleRepo;
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
@RequestMapping(value = "/category/")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("category",new Category());
        return "categorys/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "categorys/add";
        }
        if(categoryRepo.existsCategoryByName(category.getName())){
            model.addAttribute("rejectMsg","Already Have This Entry");
        }else{
            category.setName(category.getName());
            this.categoryRepo.save(category);
            model.addAttribute("category",new Category());
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "categorys/add";
    }
    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("category",categoryRepo.getOne(id));
        return "categorys/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Category category, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            return "categorys/edit";
        }
        Optional<Category> category1 = this.categoryRepo.findByName(category.getName());
        if(category1.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            return "categorys/edit";
        }else{
            category.setId(id);
            category.setName(category.getName());
            this.categoryRepo.save(category);
            model.addAttribute("category",new Category());
            model.addAttribute("successMsg","Successfully Saved!");
        }

        return "redirect:/category/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.categoryRepo.deleteById(id);
        }
        return "redirect:/category/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.categoryRepo.findAll());
        return "categorys/list";
    }


}
