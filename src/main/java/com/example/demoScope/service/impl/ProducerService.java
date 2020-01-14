package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.entity.EmployeeMongo;
import com.example.demoScope.service.EmployeeServices;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

    //KafkaProducer<String,String> producer=new KafkaProducer<String, String>(producre);

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


    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }



    private static void sendKafkaMessage(String payload,
                                         KafkaProducer<String, String> producer)
    {
        logger.info("Sending Kafka message: " + payload);
        producer.send(new ProducerRecord<>(TOPIC, payload));
    }



}
