package com.harshalmayee.services;

import com.harshalmayee.models.InvoiceStatus;
import com.harshalmayee.models.Location;

import java.util.List;

public interface InvoiceStatusService {

    public List<InvoiceStatus> getAllInvoiceStatuses();

    public void addNewInvoiceStatus(InvoiceStatus invoiceStatus);

    public InvoiceStatus getInvoiceStatusById(int id);

    void delete(int id);
}
