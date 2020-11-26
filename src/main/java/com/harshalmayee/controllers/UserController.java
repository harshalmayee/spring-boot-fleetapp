package com.harshalmayee.controllers;

import com.harshalmayee.models.Users;
import com.harshalmayee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String displayUserPage(){
        return "user";
    }

    //Modified method to Add a new user User
    @PostMapping(value="users/addNewUser")
    public RedirectView addNewUser(Users user, RedirectAttributes redir) {
        userService.addNewUser(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",
                                "You successfully registered! You can now login");
        return redirectView;
    }
}
