package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.models.VehicleMake;
import com.harshalmayee.services.LocationService;
import com.harshalmayee.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMakes")
    public String displayVehicleMakePage(Model model){
        List<VehicleMake> listOfVehicleMakes=vehicleMakeService.getAllVehicleMakes();
        model.addAttribute("listOfVehicleMakes",listOfVehicleMakes);
        return "vehicleMake";
    }

    @PostMapping("/vehicleMakes/addNewVehicleMake")
    public String addNewVehicleMake(@ModelAttribute("VehicleMake") VehicleMake vehicleMake){
        vehicleMakeService.addNewVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/vehicleMakes/getVehicleMakeById/{id}")
    @ResponseBody
    public VehicleMake getVehicleMakeById(@PathVariable(value = "id") int id){
        return vehicleMakeService.getVehicleMakeById(id);
    }

    @RequestMapping(value = "/vehicleMakes/updateVehicleMake",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleMake(@ModelAttribute("VehicleMake") VehicleMake vehicleMake){
        vehicleMakeService.addNewVehicleMake(vehicleMake);
        return "redirect:/vehicleMakes";
    }

    @RequestMapping(value = "/vehicleMakes/deleteVehicleMake/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleMake(@PathVariable(value = "id") int id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMakes";
    }
}
