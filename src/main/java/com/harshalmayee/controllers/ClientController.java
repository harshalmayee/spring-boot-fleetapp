package com.harshalmayee.controllers;

import com.harshalmayee.models.Client;
import com.harshalmayee.services.ClientService;
import com.harshalmayee.services.CountryService;
import com.harshalmayee.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String displayClientPage(Model model){
        model.addAttribute("listOfStates",stateService.getAllStates());
        model.addAttribute("countries",countryService.getAllCountries());
        model.addAttribute("listOfClients",clientService.getAllClients());
        return "client";
    }

    @PostMapping("/clients/addNewClient")
    public String addNewClient(@ModelAttribute("Client") Client client){
        clientService.addNewClient(client);
        return "redirect:/clients";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/clients/getClientById/{id}")
    @ResponseBody
    public Client getClientById(@PathVariable(value = "id") int id){
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/updateClient",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateClient(@ModelAttribute("Client") Client client){
        clientService.addNewClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/clients/deleteClient/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteClient(@PathVariable(value = "id") int id){
        clientService.delete(id);
        return "redirect:/clients";
    }
}
