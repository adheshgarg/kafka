package com.example.demoScope.service.impl;

import com.example.demoScope.entity.EmployeeMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger LOGGER=LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<EmployeeMongo,EmployeeMongo> kafkaTemplate;

    public void send(EmployeeMongo employeeMongo){

        LOGGER.info("Sending message : ",employeeMongo);
        kafkaTemplate.send("kafkaTemplate message",employeeMongo);
    }
}
