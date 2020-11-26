package com.harshalmayee.controllers;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Supplier;
import com.harshalmayee.services.ClientService;
import com.harshalmayee.services.CountryService;
import com.harshalmayee.services.StateService;
import com.harshalmayee.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupplierController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String displaySupplierPage(Model model){
        model.addAttribute("listOfStates",stateService.getAllStates());
        model.addAttribute("countries",countryService.getAllCountries());
        model.addAttribute("listOfSuppliers",supplierService.getAllSuppliers());
        return "supplier";
    }

    @PostMapping("/suppliers/addNewSupplier")
    public String addNewSupplier(@ModelAttribute("Supplier") Supplier supplier){
        supplierService.addNewSupplier(supplier);
        return "redirect:/suppliers";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/suppliers/getSupplierById/{id}")
    @ResponseBody
    public Supplier getSupplierById(@PathVariable(value = "id") int id){
        return supplierService.getSupplierById(id);
    }

    @RequestMapping(value = "/suppliers/updateSupplier",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateSupplier(@ModelAttribute("Supplier") Supplier supplier){
        supplierService.addNewSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/suppliers/deleteSupplier/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteSupplier(@PathVariable(value = "id") int id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
