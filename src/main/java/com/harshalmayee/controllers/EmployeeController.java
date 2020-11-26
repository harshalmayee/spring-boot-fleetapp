package com.harshalmayee.controllers;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Employee;
import com.harshalmayee.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @Autowired
    private JobTitleService jobTitleService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/employees")
    public String displayClientPage(Model model){
        model.addAttribute("listOfCountries",countryService.getAllCountries());
        model.addAttribute("listOfStates",stateService.getAllStates());
        model.addAttribute("listOfEmployeeTypes",employeeTypeService.getAllEmployeeTypes());
        model.addAttribute("listOfJobTitles",jobTitleService.getAllJobTitles());
        model.addAttribute("listOfEmployees",employeeService.getAllEmployees());
        return "employee";
    }

    @PostMapping("/employees/addNewEmployee")
    public String addNewEmployee(@ModelAttribute("Employee") Employee employee){
        employeeService.addNewEmployee(employee);
        return "redirect:/employees";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/employees/getEmployeeById/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable(value = "id") int id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/employees/updateEmployee",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateEmployee(@ModelAttribute("Employee") Employee employee){
        employeeService.addNewEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/deleteEmployee/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteEmployee(@PathVariable(value = "id") int id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
