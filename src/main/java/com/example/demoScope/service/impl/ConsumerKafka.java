package com.example.demoScope.service.impl;

import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.Employee;
import com.example.demoScope.entity.EmployeeMongo;
import com.example.demoScope.entity.EmployeePostgres;
import com.example.demoScope.repository.EmployeeMongoRepository;
import com.example.demoScope.repository.EmployeePostgresRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.internals.Topic;
import org.codehaus.jackson.JsonGenerationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class ConsumerKafka {

    @Autowired
    EmployeePostgresRepository employeePostgresRepository;

    @Autowired
    EmployeeMongoRepository employeeMongoRepository;


    private static int counter=0;

    @KafkaListener(topics = "test3", groupId = "group_id")
    public void consume(String message){
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        try {
            employeeDTO = objectMapper.readValue(message, EmployeeDTO.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(employeeDTO.toString());
        if(counter<150){
            EmployeeMongo employeeMongo = new EmployeeMongo();
            BeanUtils.copyProperties(employeeDTO,employeeMongo);
            employeeMongoRepository.save(employeeMongo);
            counter++;
        }
        else {
            EmployeePostgres employeePostgres = new EmployeePostgres();
            BeanUtils.copyProperties(employeeDTO,employeePostgres);
            employeePostgresRepository.save(employeePostgres);
        }
}



}