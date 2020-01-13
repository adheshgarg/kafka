package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MyThreadCSV extends Thread implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee=new Employee();

    @Override
    public ArrayList<Employee> readCSV() throws Exception {
        //CSVFile CSVFile = new CSVFile();
        ArrayList<Employee> EmployeeCSV = new ArrayList<Employee>();

        String line = " ";
        BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        String values[] = new String[100];
        for (int i = 0; i < 100; i++) {
            values = lines.get(i).split(",");
            System.out.println(Arrays.toString(values));
            ((Employee) employee).setFirstName((String) values[0]);
            ((Employee) employee).setLastName((String) values[1]);
            ((Employee) employee).setDateOfBirth((String) values[2]);
            ((Employee) employee).setExperience(new Double(values[3]).toString());

            employee.setFirstName(values[0]);
            employee.setLastName(values[1]);
            Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(values[2]);
            employee.setDateOfBirth(dateOfBirth);
            employee.setExperience((Integer.parseInt(values[3])));
            EmployeeCSV.add(employee);

        }
        return EmployeeCSV;
    }

    public MyThreadCSV() {
    }

    @Override
    public void run() {

    }


    @Override
    public ArrayList<Employee> readXML() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Employee> readJSON() throws Exception {
        return null;
    }
}
