package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.JobTitle;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.repositories.JobTitleRepository;
import com.harshalmayee.services.JobTitleService;
import com.harshalmayee.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String displayJobTitlePage(Model model){
        List<JobTitle> listOfJobTitles=jobTitleService.getAllJobTitles();
        model.addAttribute("listOfJobTitles",listOfJobTitles);
        return "jobTitle";
    }

    @PostMapping("/jobTitles/addNewJobTitle")
    public String addNewJobTitle(@ModelAttribute("JobTitle") JobTitle jobTitle){
        jobTitleService.addNewJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/jobTitles/getJobTitleById/{id}")
    @ResponseBody
    public JobTitle getJobTitleById(@PathVariable(value = "id") int id){
        return jobTitleService.getJobTitleById(id);
    }

    @RequestMapping(value = "/jobTitles/updateJobTitle",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateJobTitle(@ModelAttribute("JobTitle") JobTitle jobTitle){
        jobTitleService.addNewJobTitle(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/deleteJobTitle/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteJobTitle(@PathVariable(value = "id") int id){
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
