package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.entity.EmployeeMongo;
import com.example.demoScope.service.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProducerService implements EmployeeServices {

    private static final Logger LOGGER=LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<EmployeeMongo,EmployeeMongo> kafkaTemplate;

    public void send(EmployeeMongo employeeMongo){

        LOGGER.info("Sending message : ",employeeMongo);
        kafkaTemplate.send("kafkaTemplate message",employeeMongo);
    }

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
        return null;
    }
}
