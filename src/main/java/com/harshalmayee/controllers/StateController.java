package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.State;
import com.harshalmayee.services.CountryService;
import com.harshalmayee.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired
    private StateService stateService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String displayStatePage(Model model){
        List<State> listOfStates=stateService.getAllStates();
        model.addAttribute("listOfStates",listOfStates);

        List<Country> countries=countryService.getAllCountries();
        model.addAttribute("countries",countries);
        return "state";
    }

    @PostMapping("/states/addNewState")
    public String addNewState(@ModelAttribute("State") State state){
        stateService.addNewState(state);
        return "redirect:/states";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/states/getStateById/{id}")
    @ResponseBody
    public State getStateById(@PathVariable(value = "id") int id){
        return stateService.getStateById(id);
    }

    @RequestMapping(value = "/states/updateState",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateState(@ModelAttribute("State") State state){
        stateService.addNewState(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/deleteState/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteState(@PathVariable(value = "id") int id){
        stateService.delete(id);
        return "redirect:/states";
    }
}
