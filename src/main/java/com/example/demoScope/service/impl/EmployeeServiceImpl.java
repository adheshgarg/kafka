package com.example.demoScope.service.impl;

import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;
}
