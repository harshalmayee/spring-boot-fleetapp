package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String displayCountryPage(Model model){
        List<Country> listOfCountries=countryService.getAllCountries();
        model.addAttribute("listOfCountries",listOfCountries);
        return "country";
    }

    @PostMapping("/countries/addNewCountry")
    public String addNewCountry(@ModelAttribute("Country") Country country){
        countryService.addNewCountry(country);
        return "redirect:/countries";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/countries/getCountryById/{id}")
    @ResponseBody
    public Country getCountryById(@PathVariable(value = "id") int id){
       return countryService.getCountryById(id);
    }

    @RequestMapping(value = "/countries/updateCountry",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateCountry(@ModelAttribute("Country") Country country){
        countryService.addNewCountry(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/deleteCountry/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteCountry(@PathVariable(value = "id") int id){
        countryService.delete(id);
        return "redirect:/countries";
    }



}
