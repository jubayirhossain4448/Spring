package com.israt.carrentalproject.Controller;


import com.israt.carrentalproject.Entity.User;
import com.israt.carrentalproject.Repo.RoleRepo;
import com.israt.carrentalproject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("rolelist",roleRepo.findAll());
        return "users/add";
    }
    @PostMapping(value = "add")
    public String add(@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("rolelist",roleRepo.findAll());
            return "users/add";
        }
        if(repo.existsByEmail(user.getEmail())){
            model.addAttribute("rejectMsg","Already Have This Entry");
            model.addAttribute("rolelist",roleRepo.findAll());
        }else{
            String username = user.getEmail().split("\\@")[0];
            user.setUserName(username);
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setConfirmationToken(UUID.randomUUID().toString());
            this.repo.save(user);
            model.addAttribute("user",new User());
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("rolelist",roleRepo.findAll());

        }

        return "users/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",repo.getOne(id));
        model.addAttribute("rolelist",roleRepo.findAll());
        return "users/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid User user, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("rolelist",roleRepo.findAll());
            return "users/edit";
        }
        Optional<User> u = this.repo.findByEmail(user.getEmail());
        if(u.get().getId() != id){
            model.addAttribute("rejectMsg","Already Have This Entry");
            model.addAttribute("rolelist",roleRepo.findAll());
            return "users/edit";
        }else{
            user.setId(id);
            user.setUserName(u.get().getUserName());
            user.setPassword(u.get().getPassword());
            user.setRegiDate(u.get().getRegiDate());
            user.setEnabled(true);
            user.setConfirmationToken(u.get().getConfirmationToken());
            this.repo.save(user);
            model.addAttribute("user",new User());
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("rolelist",roleRepo.findAll());
        }

        return "redirect:/user/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
          model.addAttribute("list",this.repo.findAll());
        return "users/list";
    }

}
