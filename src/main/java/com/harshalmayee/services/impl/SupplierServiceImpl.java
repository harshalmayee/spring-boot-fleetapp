package com.harshalmayee.services.impl;

import com.harshalmayee.models.Supplier;
import com.harshalmayee.repositories.SupplierRepository;
import com.harshalmayee.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public void addNewSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public Supplier getSupplierById(int id) {
        Optional<Supplier> optional =supplierRepository.findById(id);
        Supplier supplier=null;
        if(optional.isPresent()){
            supplier=optional.get();
        }else{
            throw new RuntimeException("Supplier Not Found"+id);
        }
        return supplier;
    }

    @Override
    public void delete(int id) {
       supplierRepository.deleteById(id);
    }
}
