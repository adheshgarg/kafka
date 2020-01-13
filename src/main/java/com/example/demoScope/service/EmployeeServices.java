package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

    ArrayList<Employee> readcsv() throws Exception;

    ArrayList<Employee> readXml() throws Exception;

    ArrayList<Employee> readJSON() throws Exception;

}
