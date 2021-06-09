package com.harshalmayee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login1";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login1";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
