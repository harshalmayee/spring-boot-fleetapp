package com.harshalmayee.services.impl;

import com.harshalmayee.models.EmployeeType;
import com.harshalmayee.models.InvoiceStatus;
import com.harshalmayee.models.Location;
import com.harshalmayee.repositories.EmployeeTypeRepository;
import com.harshalmayee.repositories.LocationRepository;
import com.harshalmayee.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getAllEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    @Override
    public void addNewEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    @Override
    public EmployeeType getEmployeeTypeById(int id) {
        Optional<EmployeeType> optional=employeeTypeRepository.findById(id);
        EmployeeType employeeType=null;
        if(optional.isPresent()){
            employeeType=optional.get();
        }else{
            throw new RuntimeException("Employee Type  Not Found :"+id);
        }
        return employeeType;
    }

    @Override
    public void delete(int id) {
        employeeTypeRepository.deleteById(id);
    }
}
