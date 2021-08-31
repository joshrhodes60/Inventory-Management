package org.launchcode.inventorymanagement.controllers;

import org.launchcode.inventorymanagement.models.data.JobRepository;
import org.launchcode.inventorymanagement.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class HomeController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute(new Job());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        jobRepository.save(newJob);
        return "redirect:";
    }
    @RequestMapping(path = "view/delete/{id}")
    public String processDeleteJobForm(Model model, @PathVariable("id") String id) {

//        if (errors.hasErrors()) {
//            return "view";// handle when errors
//        }

        jobRepository.deleteById(Integer.parseInt(id));
        return "add";
    }

//    @PostMapping("/delete")
//    public String processDeleteJobForm(@RequestParameter("id") long jobId) {
//
//
//        jobRepository.deleteJob(jobId);
//        return "redirect:";
//    }

//    @RequestMapping(path = "/delete/{id}")
//    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
//            throws RecordNotFoundException
//    {
//        service.deleteEmployeeById(id);
//        return "redirect:/";
//    }


        @GetMapping("view/{jobId}")
        public String displayViewJob (Model model,@PathVariable int jobId){

            Optional optJob = jobRepository.findById(jobId);
            if (!optJob.isEmpty()) {
                Job job = (Job) optJob.get();
                model.addAttribute("job", job);
                return "view";
            } else {
                return "redirect:/";
            }
        }


}