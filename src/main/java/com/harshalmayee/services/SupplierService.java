package com.harshalmayee.services;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Supplier;

import java.util.List;

public interface SupplierService {

    public List<Supplier> getAllSuppliers();

    public void addNewSupplier(Supplier supplier);

    public Supplier getSupplierById(int id);

    void delete(int id);
}
