package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import org.bson.internal.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
=======
import java.io.ObjectOutputStream;

>>>>>>> 5cfc2dfaf3b289f641816c2a8221ef557531f939

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";


    /*@Value("${kafka.topic.json}")
    private String jsonTopic;*/

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public void sendMessage(Employee employee) {
        logger.info("sending employee='{}'", employee.toString());
        kafkaTemplate.send(TOPIC, employee);
        }

}
