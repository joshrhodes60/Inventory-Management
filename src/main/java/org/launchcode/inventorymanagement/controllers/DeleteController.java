package org.launchcode.inventorymanagement.controllers;

import org.launchcode.inventorymanagement.models.Job;
import org.launchcode.inventorymanagement.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


//@Controller
//public class DeleteController {
//    @Autowired
//    private JobRepository jobRepository;
//
//    @RequestMapping("")
//    public String index(Model model) {
//        model.addAttribute("jobs", jobRepository.findAll());
//        return "index";
//    }

//    @GetMapping("delete")
//    public String displayDeleteJobForm(Model model) {
//        model.addAttribute(new Job());
//        return "delete";
//    }

//    @PostMapping("delete")
//    public String processDeleteJobForm(@ModelAttribute @Valid Job newJob,
//                                       Errors errors) {
//
//        if (errors.hasErrors()) {
//            return "delete";
//        }
//
//        jobRepository.save(newJob);
//        return "redirect:";
//    }
//}

