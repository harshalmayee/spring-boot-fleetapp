package com.harshalmayee.services.impl;

import com.harshalmayee.models.Invoice;
import com.harshalmayee.models.State;
import com.harshalmayee.repositories.InvoiceRepository;
import com.harshalmayee.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public void addNewInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Optional<Invoice> optional=invoiceRepository.findById(id);
        Invoice invoice=null;
        if(optional.isPresent()){
            invoice=optional.get();
        }else{
            throw new RuntimeException("Invoice Not Found :"+id);
        }
        return invoice;
    }

    @Override
    public void delete(int id) {
        invoiceRepository.deleteById(id);
    }
}
