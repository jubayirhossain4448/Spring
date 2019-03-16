package com.israt.carrentalproject.Controller;



import com.israt.carrentalproject.Entity.Agency;

import com.israt.carrentalproject.Repo.AddressRepo;
import com.israt.carrentalproject.Repo.AgencyRepo;
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
@RequestMapping(value = "/agency/")
public class AgencyController {

       @Autowired
        private AgencyRepo agencyRepo;

    @Autowired
    private AddressRepo addressRepo;

        @GetMapping(value = "add")
        public String viewAdd(Model model) {
            model.addAttribute("agency", new Agency());
            model.addAttribute("addresslist",addressRepo.findAll());
            return "agencys/add";
        }


    @PostMapping(value = "add")
   public String add(@Valid Agency agency, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("rejectMsg","Somthing is wrong");
            return "agencys/add";
        }else{
            this.agencyRepo.save(agency);
           model.addAttribute("agency",new Agency());
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("addresslist",addressRepo.findAll());
       }

        return "agencys/add";
   }

        @GetMapping(value = "edit/{id}")
        public String viewEdit(Model model, @PathVariable("id") Long id){
            model.addAttribute("agency",agencyRepo.getOne(id));
            model.addAttribute("addresslist",addressRepo.findAll());
            return "agencys/edit";
        }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Agency agency, BindingResult result, Model model,@PathVariable("id") Long id) {
        if (result.hasErrors()) {
            model.addAttribute("rejectMsg","Somthing is wrong");
            model.addAttribute("addresslist",addressRepo.findAll());
            return "agencys/edit";
        } else {
//            agency.setId(id);
            this.agencyRepo.save(agency);
            model.addAttribute("agency",new Agency());
            model.addAttribute("successMsg","Successfully Saved!");
            model.addAttribute("addresslist",addressRepo.findAll());
            return "redirect:/agency/list";
        }
    }

        @GetMapping(value = "del/{id}")
        public String del(@PathVariable("id") Long id){
            if(id != null) {
                this.agencyRepo.deleteById(id);

            }
            return "redirect:/agency/list";
        }

        @GetMapping(value = "list")
        public String list(Model model){
            model.addAttribute("list",this.agencyRepo.findAll());
            return "agencys/list";
        }

    }



