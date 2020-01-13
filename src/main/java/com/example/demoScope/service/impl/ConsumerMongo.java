package com.example.demoScope.service.impl;

import com.example.demoScope.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMongo extends Thread{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run() {
        super.run();
    }
}
