package com.example.demoScope.service;

import com.example.demoScope.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface EmployeeServices {

<<<<<<< HEAD
    ArrayList<Employee> readcsv();
=======
    ArrayList<Employee> readCSV() throws Exception;
>>>>>>> d981bd1a6aa1b57804af3da2cc23e55d2dd8d54f

    ArrayList<Employee> readXML() throws Exception;

    ArrayList<Employee> readJSON() throws Exception;

}
