package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

    ArrayList<Employee> readCSV() throws Exception;

    ArrayList<Employee> readXML() throws Exception;

    ArrayList<Employee> readJSON() throws Exception;

    public void sendMessage();
}

