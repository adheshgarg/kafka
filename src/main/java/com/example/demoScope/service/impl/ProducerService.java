package com.example.demoScope.service.impl;
import com.example.demoScope.service.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements EmployeeServices {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static final String TOPIC = "Kafka_Employee_json";


    /*@Value("${kafka.topic.json}")
    private String jsonTopic;*/

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //Employee employee=new Employee();
        logger.info("sending employee='{}'", message);
        kafkaTemplate.send(TOPIC, message);
    }

    @Override
    public void consume(String message) {

    }
}
