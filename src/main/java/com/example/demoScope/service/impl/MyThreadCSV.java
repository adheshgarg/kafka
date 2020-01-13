package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MyThreadCSV extends Thread {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee readCSV() throws Exception {
        //CSVFile CSVFile = new CSVFile();
        String line = " ";
        BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
        List<String> lines = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        String values[] = new String[100];
        ArrayList<Employee> empcsv = new ArrayList<Employee>();
        for (int i = 0; i < 100; i++) {
            //Employee e=new Employee();
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
        }
        return employee;
    }

    public MyThreadCSV() {
    }

    @Override
    public void run() {

    }
}
