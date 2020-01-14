package com.example.demoScope.service.impl;

import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.Employee;
import com.example.demoScope.entity.EmployeeMongo;
import com.example.demoScope.repository.EmployeeMongoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class ConsumerMongo extends Thread {


    private static final String TOPIC = "Kafka_Employee_json";


    @Autowired
    @Qualifier("EmployeeMongoRepository")
    EmployeeMongoRepository employeeMongoRepository;
    private static int counter = 0;
    @KafkaListener(topics = "Kafka_Employee_json", groupId = "group_id")
    public void consume(Employee employee) {

        System.out.println(employee.toString());
        if (counter < 150) {
            EmployeeMongo employeeMongo = new EmployeeMongo();
            BeanUtils.copyProperties(employee, employeeMongo);
            employeeMongoRepository.save(employeeMongo);
            counter++;

        }}




}

