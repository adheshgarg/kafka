package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";


    /*@Value("${kafka.topic.json}")
    private String jsonTopic;*/

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Employee employee) {

        String jsonString="";
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            jsonString=objectMapper.writeValueAsString(employee);
            System.out.println(jsonString);
        }
        catch(IOException io){
            io.printStackTrace();
        }

        //Employee employee=new Employee();
        logger.info("sending employee='{}'", jsonString);
        kafkaTemplate.send(TOPIC, jsonString);
    }

}
//KafkaProducer<String,String> producer=new KafkaProducer<String, String>(producre);
