package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeServices {
    void consume(String message);

    public void sendMessage();
}

