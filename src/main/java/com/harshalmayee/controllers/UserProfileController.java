package com.harshalmayee.controllers;


import com.harshalmayee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserProfileController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String userName=principal.getName();
        model.addAttribute("employee",employeeService.findByUserName(userName));
        return "profile";
    }
}
