package com.harshalmayee.services.impl;

import com.harshalmayee.models.InvoiceStatus;
import com.harshalmayee.models.Location;
import com.harshalmayee.models.VehicleType;
import com.harshalmayee.repositories.InvoiceStatusRepository;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusServiceImpl implements InvoiceStatusService {

    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    @Override
    public List<InvoiceStatus> getAllInvoiceStatuses() {
        return invoiceStatusRepository.findAll();
    }

    @Override
    public void addNewInvoiceStatus(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    @Override
    public InvoiceStatus getInvoiceStatusById(int id) {
        Optional<InvoiceStatus> optional=invoiceStatusRepository.findById(id);
        InvoiceStatus invoiceStatus=null;
        if(optional.isPresent()){
            invoiceStatus=optional.get();
        }else{
            throw new RuntimeException("Invoice Status Value  Not Found :"+id);
        }
        return invoiceStatus;
    }

    @Override
    public void delete(int id) {
        invoiceStatusRepository.deleteById(id);
    }
}
