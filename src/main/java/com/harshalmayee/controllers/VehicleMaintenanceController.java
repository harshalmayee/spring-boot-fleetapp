package com.harshalmayee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehicleMaintenances")
    public String displayVehicleMaintenancePage(){
        return "vehicleMaintenance";
    }
}
