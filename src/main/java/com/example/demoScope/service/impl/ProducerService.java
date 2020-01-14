package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee employee) {
        logger.info("sending employee='{}'", employee.toString());
        kafkaTemplate.send(TOPIC, employee);
        System.out.println("in Kafka");
        }

}
