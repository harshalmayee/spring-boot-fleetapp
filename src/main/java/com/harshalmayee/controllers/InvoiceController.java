package com.harshalmayee.controllers;

import com.harshalmayee.models.Country;
import com.harshalmayee.models.Invoice;
import com.harshalmayee.models.State;
import com.harshalmayee.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public String displayInvoicePage(Model model){
        model.addAttribute("listOfInvoiceStatuses",invoiceStatusService.getAllInvoiceStatuses());
        model.addAttribute("listOfClients",clientService.getAllClients());
        model.addAttribute("listOfInvoices",invoiceService.getAllInvoices());
        return "invoice";
    }

    @PostMapping("/invoices/addNewInvoice")
    public String addNewInvoice(@ModelAttribute("Invoice") Invoice invoice){
        invoiceService.addNewInvoice(invoice);
        return "redirect:/invoices";
    }

    // @GetMapping("/countries/getCountryById/{id}")
    @RequestMapping("/invoices/getInvoiceById/{id}")
    @ResponseBody
    public Invoice getInvoiceById(@PathVariable(value = "id") int id)
    {
        return invoiceService.getInvoiceById(id);
    }

    @RequestMapping(value = "/invoices/updateInvoice",method = {RequestMethod.PUT,RequestMethod.GET})
    public String updateInvoice(@ModelAttribute("Invoice") Invoice invoice){
        invoiceService.addNewInvoice(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/deleteInvoice/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoice(@PathVariable(value = "id") int id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
