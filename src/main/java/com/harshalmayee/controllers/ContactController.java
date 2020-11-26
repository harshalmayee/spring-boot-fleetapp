package com.harshalmayee.controllers;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Contact;
import com.harshalmayee.services.ClientService;
import com.harshalmayee.services.ContactService;
import com.harshalmayee.services.CountryService;
import com.harshalmayee.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String displayContactPage(Model model){
        model.addAttribute("listOfContacts",contactService.getAllContacts());
        return "contact";
    }

    @PostMapping("/contacts/addNewContact")
    public String addNewContact(@ModelAttribute("Contact") Contact contact){
        contactService.addNewContact(contact);
        return "redirect:/contacts";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/contacts/getContactById/{id}")
    @ResponseBody
    public Contact getContactById(@PathVariable(value = "id") int id){
        return contactService.getContactById(id);
    }

    @RequestMapping(value = "/contacts/updateContact",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateContact(@ModelAttribute("Contact") Contact contact){
        contactService.addNewContact(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/deleteContact/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteContact(@PathVariable(value = "id") int id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
