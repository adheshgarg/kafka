package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class ConsumerService {

    private static final String TOPIC = "Kafka_Employee_json";



    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

        @KafkaListener(topics = "Kafka_Employee_json", groupId = "group_id")
        public void consume(){
            while(true){
            ConsumerRecords<String,String> consumerRecords=kafkaConsumer.poll(100);

            for (ConsumerRecord<String,String> record:consumerRecords
                 ) {
                String message1=record.value();
                logger.info(String.format("$$ -> Consumed Message -> %s",message1));

            }}

            //logger.info(String.format("$$ -> Consumed Message -> %s",message));
    }


    private KafkaConsumer<String,String> kafkaConsumer;



    @Bean
    public KafkaConsumer<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new KafkaConsumer<String, String>(config);

    }

    public ConsumerService(){
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
    }





}
