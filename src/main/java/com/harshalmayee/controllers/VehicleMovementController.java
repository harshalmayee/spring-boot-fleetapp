package com.harshalmayee.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

    @GetMapping("/vehicleMovements")
    public String displayVehicleMovementPage(){
        return "vehicleMovement";
    }
}
