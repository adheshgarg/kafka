package com.example.demoScope.service;

import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

    ArrayList<EmployeeDTO> readCSV() throws Exception;

    ArrayList<EmployeeDTO> readXML() throws Exception;

    ArrayList<EmployeeDTO> readJSON() throws Exception;

}
