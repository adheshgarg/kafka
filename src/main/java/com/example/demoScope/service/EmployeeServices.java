package com.example.demoScope.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeServices {
    void consume(String message);

    public void sendMessage(String message);
}

