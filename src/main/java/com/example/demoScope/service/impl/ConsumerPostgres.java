package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerPostgres extends Thread implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run() {
        super.run();
    }


    @Override
    public void sendMessage() {

    }
}
