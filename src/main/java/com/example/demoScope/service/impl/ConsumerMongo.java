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
<<<<<<< HEAD
        }
    }

        @Override
        public void run () {
            super.run();
            this.consume();


        }


    @Autowired
    private KafkaConsumer<String,String> kafkaConsumer;



    @Bean
    public KafkaConsumer<String, String> consumerFactoryMongo() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new KafkaConsumer<String, String>(config);

    }

    public ConsumerMongo(){
        kafkaConsumer=consumerFactoryMongo();
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
    }
=======

>>>>>>> 5cfc2dfaf3b289f641816c2a8221ef557531f939



}

