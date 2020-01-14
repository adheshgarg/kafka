package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.function.Consumer;


@Service
public class ConsumerService {


        private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

        @KafkaListener(topics = "Kafka_Employee_json", groupId = "group_id")
        public void consume(Employee employee){
            //logger.info(String.format("$$ -> Consumed Message -> %s",message));


    }

}
