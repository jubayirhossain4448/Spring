package com.jubayir.demoofeditingimage.controller;

import com.jubayir.demoofeditingimage.entity.ImageOptimizer;
import com.jubayir.demoofeditingimage.entity.Role;
import com.jubayir.demoofeditingimage.entity.Student;
import com.jubayir.demoofeditingimage.repository.RoleRepo;
import com.jubayir.demoofeditingimage.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class StudentController {

    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private StudentRepo repo;

    @Autowired
    private RoleRepo roleRepo; // for creating role list

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("list", this.repo.findAll());
        this.repo.findAll().forEach((c) -> {
            System.out.println(c.toString());
        });
        return "index";
    }

    @GetMapping("/add")
    public String showForm(Student student, Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll()); // for creating role list relationship

        return "add-page";
    }

    @PostMapping("/add")
    private String save(@Valid Student student, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file){
        if (bindingResult.hasErrors()){
            return "add-page";
        }
        student.setRegiDate(new Date());

        try {
            //////////////////////For Image Upload start /////////////////////
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

            Files.write(path, bytes);
            student.setFileName("new-" + file.getOriginalFilename());
            student.setFileSize(file.getSize());
            // user.setFile(file.getBytes());
            student.setFilePath("images/" + "new-" + file.getOriginalFilename());
            student.setFileExtension(file.getContentType());
            //////////////////////For Image Upload end/////////////////////
            this.repo.save(student);
            model.addAttribute("user", new Student());
            model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
            imageOptimizer.optimizeImage(UPLOADED_FOLDER, file, 0.3f, 100, 100);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("roleList", this.roleRepo.findAll()); // for add role list relationship
        return "add-page";

    }

    @GetMapping("/edit/{id}")
    public String editView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("student", this.repo.getOne(id));
        return "edit-page";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid Student student, BindingResult bindingResult,
                       @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "edit-page";
        }
        this.repo.save(student);
        return "redirect:/";
    }

    @GetMapping(value = "/del/{id}")
    public String delete(@PathVariable ("id") Long id){
        if(id != null){
            this.repo.deleteById(id);
        }
        return "redirect:/";
    }


}
