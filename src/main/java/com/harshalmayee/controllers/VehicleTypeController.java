package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.models.VehicleType;
import com.harshalmayee.services.LocationService;
import com.harshalmayee.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleTypes")
    public String displayVehicleTypePage(Model model){
        List<VehicleType> listOfVehicleTypes=vehicleTypeService.getAllVehicleTypes();
        model.addAttribute("listOfVehicleTypes",listOfVehicleTypes);
        return "vehicleType";
    }

    @PostMapping("/vehicleTypes/addNewVehicleType")
    public String addNewVehicleType(@ModelAttribute("VehicleType") VehicleType vehicleType){
        vehicleTypeService.addNewVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/vehicleTypes/getVehicleTypeById/{id}")
    @ResponseBody
    public VehicleType getVehicleTypeById(@PathVariable(value = "id") int id){
        return vehicleTypeService.getVehicleTypeById(id);
    }

    @RequestMapping(value = "/vehicleTypes/updateVehicleType",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleType(@ModelAttribute("VehicleType") VehicleType vehicleType){
        vehicleTypeService.addNewVehicleType(vehicleType);
        return "redirect:/vehicleTypes";
    }

    @RequestMapping(value = "/vehicleTypes/deleteVehicleType/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleType(@PathVariable(value = "id") int id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicleTypes";
    }
}
