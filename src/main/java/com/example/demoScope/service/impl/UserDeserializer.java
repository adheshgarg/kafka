package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserDeserializer implements Deserializer {

    @Override public void close() {

    }

    @Override public void configure(Map<String, ?> arg0, boolean arg1) {

    }

    @Override
    public Employee deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = null;
        try {
            employee = mapper.readValue(arg1, Employee.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return employee;
    }


}
