package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.EmployeeType;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.services.EmployeeTypeService;
import com.harshalmayee.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeTypes")
    public String displayEmployeeTypePage(Model model){
        List<EmployeeType> listOfEmployeeTypes=employeeTypeService.getAllEmployeeTypes();
        model.addAttribute("listOfEmployeeTypes",listOfEmployeeTypes);
        return "employeeType";
    }

    @PostMapping("/employeeTypes/addNewEmployeeType")
    public String addNewEmployeeType(@ModelAttribute("EmployeeType") EmployeeType employeeType){
        employeeTypeService.addNewEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/employeeTypes/getEmployeeTypeById/{id}")
    @ResponseBody
    public EmployeeType getEmployeeTypeById(@PathVariable(value = "id") int id){
        return employeeTypeService.getEmployeeTypeById(id);
    }

    @RequestMapping(value = "/employeeTypes/updateEmployeeType",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateEmployeeType(@ModelAttribute("EmployeeType") EmployeeType employeeType){
        employeeTypeService.addNewEmployeeType(employeeType);
        return "redirect:/employeeTypes";
    }

    @RequestMapping(value = "/employeeTypes/deleteEmployeeType/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteEmployeeType(@PathVariable(value = "id") int id){
        employeeTypeService.delete(id);
        return "redirect:/employeeTypes";
    }
}
