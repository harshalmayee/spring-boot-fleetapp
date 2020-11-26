package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.models.VehicleModel;
import com.harshalmayee.services.LocationService;
import com.harshalmayee.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModels")
    public String displayVehicleModelPage(Model model){
        List<VehicleModel> listOfVehicleModels=vehicleModelService.getAllVehicleModels();
        model.addAttribute("listOfVehicleModels",listOfVehicleModels);
        return "vehicleModel";
    }

    @PostMapping("/vehicleModels/addNewVehicleModel")
    public String addNewVehicleModel(@ModelAttribute("VehicleModel") VehicleModel vehicleModel){
        vehicleModelService.addNewVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/vehicleModels/getVehicleModelById/{id}")
    @ResponseBody
    public VehicleModel getVehicleModelById(@PathVariable(value = "id") int id){
        return vehicleModelService.getVehicleModelById(id);
    }

    @RequestMapping(value = "/vehicleModels/updateVehicleModel",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleModel(@ModelAttribute("VehicleModel") VehicleModel vehicleModel){
        vehicleModelService.addNewVehicleModel(vehicleModel);
        return "redirect:/vehicleModels";
    }

    @RequestMapping(value = "/vehicleModels/deleteVehicleModel/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleModel(@PathVariable(value = "id") int id){
        vehicleModelService.delete(id);
        return "redirect:/vehicleModels";
    }
}
