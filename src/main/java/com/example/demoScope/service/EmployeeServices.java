package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

    void readCSV() throws Exception;

    void readXML() throws Exception;

    void readJSON() throws Exception;
}
