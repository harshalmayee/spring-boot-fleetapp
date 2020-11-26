package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.InvoiceStatus;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.State;
import com.harshalmayee.services.InvoiceStatusService;
import com.harshalmayee.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String displayInvoiceStatusPage(Model model){
        List<InvoiceStatus> listOfInvoiceStatuses=invoiceStatusService.getAllInvoiceStatuses();
        model.addAttribute("listOfInvoiceStatuses",listOfInvoiceStatuses);
        return "invoiceStatus";
    }

    @PostMapping("/invoiceStatuses/addNewInvoiceStatus")
    public String addNewInvoiceStatus(@ModelAttribute("InvoiceStatus") InvoiceStatus invoiceStatus){
        invoiceStatusService.addNewInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/invoiceStatuses/getInvoiceStatusById/{id}")
    @ResponseBody
    public InvoiceStatus getInvoiceStatusById(@PathVariable(value = "id") int id){
        return invoiceStatusService.getInvoiceStatusById(id);
    }

    @RequestMapping(value = "/invoiceStatuses/updateInvoiceStatus",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateInvoiceStatus(@ModelAttribute("InvoiceStatus") InvoiceStatus invoiceStatus){
        invoiceStatusService.addNewInvoiceStatus(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/deleteInvoiceStatus/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoiceStatus(@PathVariable(value = "id") int id){
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }
}
