package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConsumerMongo extends Thread implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run() {
        super.run();
    }

    @Override
    public ArrayList<Employee> readCSV() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Employee> readXML() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Employee> readJSON() throws Exception {
        return null;
    }
}
