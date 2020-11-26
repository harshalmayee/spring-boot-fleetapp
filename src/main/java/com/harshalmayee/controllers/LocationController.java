package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.services.CountryService;
import com.harshalmayee.services.LocationService;
import com.harshalmayee.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String displayLocationPage(Model model){
        List<State> listOfStates=stateService.getAllStates();
        model.addAttribute("listOfStates",listOfStates);

        List<Country> countries=countryService.getAllCountries();
        model.addAttribute("countries",countries);

        List<Location> listOfLocations=locationService.getAllLocations();
        model.addAttribute("listOfLocations",listOfLocations);
        return "location";
    }

    @PostMapping("/locations/addNewLocation")
    public String addNewLocation(@ModelAttribute("Location") Location location){
        locationService.addNewLocation(location);
        return "redirect:/locations";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/locations/getLocationById/{id}")
    @ResponseBody
    public Location getLocationById(@PathVariable(value = "id") int id){
        return locationService.getLocationById(id);
    }

    @RequestMapping(value = "/locations/updateLocation",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateLocation(@ModelAttribute("Location") Location location){
        locationService.addNewLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/deleteLocation/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteLocation(@PathVariable(value = "id") int id){
        locationService.delete(id);
        return "redirect:/locations";
    }
}
