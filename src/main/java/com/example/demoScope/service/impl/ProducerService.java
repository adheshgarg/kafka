package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.service.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements EmployeeServices {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";


    @Value("${kafka.topic.json}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage() {
        Employee employee=new Employee();
        logger.info("sending car='{}'", employee.toString());
        kafkaTemplate.send(jsonTopic, employee);
    }

}
