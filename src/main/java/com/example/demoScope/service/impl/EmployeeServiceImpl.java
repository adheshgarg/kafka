package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeePostgresRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    EmployeePostgresRepository employeePostgresRepository;

    @Override
    public Employee saveIt(Employee employee)
    {
        return employeePostgresRepository.save(employee);
    }
}
