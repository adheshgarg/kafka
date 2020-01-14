package com.example.demoScope.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;



@Service
public interface EmployeeServices {

    public void sendMessage() throws JsonProcessingException;
}

