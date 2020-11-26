package com.harshalmayee.services;

import com.harshalmayee.models.Client;
import com.harshalmayee.models.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void addNewEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void delete(int id);

    Employee findByUserName(String userName);
}
