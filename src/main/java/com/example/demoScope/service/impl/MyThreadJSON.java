package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.EmployeeRepository;
import com.example.demoScope.service.ThreadInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "MyThreadJSON")
public class MyThreadJSON extends Thread implements ThreadInterface {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void read() {
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("employee.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray jsonArrayRead = (JSONArray) obj;

        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee();


            JSONObject data = (JSONObject) jsonArrayRead.get(i);

            String dateOfBirth = (String) data.get("dateOfBirth");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy");

            Date date = null;
            try {
                date = simpleDateFormat.parse(dateOfBirth);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            String firstname = (String) data.get("firstName");
            emp.setFirstName(firstname);

            String lastname = (String) data.get("lastName");
            emp.setLastName(lastname);

            emp.setDateOfBirth(date);

            long Experience = (long) data.get("experience");
            emp.setExperience(Experience);

            String jsonString="";
            ObjectMapper objectMapper=new ObjectMapper();
            try{
                jsonString=objectMapper.writeValueAsString(emp);
                System.out.println(jsonString);
            }
            catch(IOException io){
                io.printStackTrace();
            }

            ProducerService producerService=new ProducerService();
            producerService.sendMessage(jsonString);
        }
    }



    public MyThreadJSON() {
    }

    @Override
    public void run() {
        super.run();
        try {
            this.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
