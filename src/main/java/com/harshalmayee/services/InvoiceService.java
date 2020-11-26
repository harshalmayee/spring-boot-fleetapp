package com.harshalmayee.services;

import com.harshalmayee.models.Invoice;
import com.harshalmayee.models.State;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> getAllInvoices();

    public void addNewInvoice(Invoice invoice);

    public Invoice getInvoiceById(int id);

    void delete(int id);
}
