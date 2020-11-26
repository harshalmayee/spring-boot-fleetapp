package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.models.VehicleStatus;
import com.harshalmayee.services.LocationService;
import com.harshalmayee.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatuses")
    public String displayVehicleStatusPage(Model model){
        List<VehicleStatus> listOfVehicleStatuses=vehicleStatusService.getAllVehicleStatuses();
        model.addAttribute("listOfVehicleStatuses",listOfVehicleStatuses);
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatuses/addNewVehicleStatus")
    public String addNewVehicleStatus(@ModelAttribute("VehicleStatus") VehicleStatus vehicleStatus){
        vehicleStatusService.addNewVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/vehicleStatuses/getVehicleStatusById/{id}")
    @ResponseBody
    public VehicleStatus getVehicleStatusById(@PathVariable(value = "id") int id){
        return vehicleStatusService.getVehicleStatusById(id);
    }

    @RequestMapping(value = "/vehicleStatuses/updateVehicleStatus",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateVehicleStatus(@ModelAttribute("VehicleStatus") VehicleStatus vehicleStatus){
        vehicleStatusService.addNewVehicleStatus(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/deleteVehicleStatus/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteVehicleStatus(@PathVariable(value = "id") int id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }
}
