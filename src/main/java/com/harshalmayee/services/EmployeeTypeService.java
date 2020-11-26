package com.harshalmayee.services;

import com.harshalmayee.models.EmployeeType;
import com.harshalmayee.models.Location;

import java.util.List;

public interface EmployeeTypeService {

    public List<EmployeeType> getAllEmployeeTypes();

    public void addNewEmployeeType(EmployeeType employeeType);

    public EmployeeType getEmployeeTypeById(int id);

    void delete(int id);
}
