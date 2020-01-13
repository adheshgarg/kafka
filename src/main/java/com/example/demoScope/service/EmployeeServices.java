package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

    ArrayList<Employee> readcsv();

    ArrayList<Employee> readXml();

    ArrayList<Employee> readJSON();

}
