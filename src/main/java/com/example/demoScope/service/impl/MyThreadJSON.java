package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.EmployeeServices;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class MyThreadJSON extends Thread implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ArrayList<Employee> readCSV() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Employee> readXML() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Employee> readJSON() throws Exception {
        ArrayList<Employee> employeeArray = new ArrayList();
        Object obj = new JSONParser().parse(new FileReader("employee.json"));

        JSONArray jsonArrayRead = (JSONArray) obj;

        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee();


            JSONObject data = (JSONObject) jsonArrayRead.get(i);

            String dateOfBirth = (String) data.get("dateOfBirth");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");

            Date date = simpleDateFormat.parse(dateOfBirth);
            String firstname = (String) data.get("firstName");
            emp.setFirstName(firstname);

            String lastname = (String) data.get("lastName");
            emp.setLastName(lastname);

            emp.setDateOfBirth(date);

            long Experience = (long) data.get("experience");
            emp.setExperience(Experience);


            employeeArray.add(emp);


        }
        return employeeArray;
    }


    public MyThreadJSON() {
    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void run() {
        super.run();
        try {
            this.readJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
