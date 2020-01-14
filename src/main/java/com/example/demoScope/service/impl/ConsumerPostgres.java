package com.example.demoScope.service.impl;
import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.EmployeePostgres;
import com.example.demoScope.repository.EmployeePostgresRepository;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConsumerPostgres extends Thread {

    private static final String TOPIC = "Kafka_Employee_json";

    private static int counter = 0;


    @Autowired
    @Qualifier("EmployeePostgresRepository")
    EmployeePostgresRepository employeePostgresRepository;


    @KafkaListener(topics = "Kafka_Employee_json", groupId = "group_id")
    public void consume() {


        while(true){
            ConsumerRecords<String,String> consumerRecords=kafkaConsumer.poll(100);

            for (ConsumerRecord<String,String> record:consumerRecords
                    ) {
                String message1=record.value();



                ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        try {
            employeeDTO = objectMapper.readValue(message1,EmployeeDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employeeDTO.toString());
        if(counter < 150){
        EmployeePostgres employeePostgres = new EmployeePostgres();
        BeanUtils.copyProperties(employeeDTO, employeePostgres);
        employeePostgresRepository.save(employeePostgres);
        counter++;}

            }}
    }



    @Override
    public void run () {
        super.run();
        this.consume();


    }


    @Autowired
    private KafkaConsumer<String,String> kafkaConsumer;



    @Bean
    public KafkaConsumer<String, String> consumerFactoryPostgres() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new KafkaConsumer<String, String>(config);

    }

    public ConsumerPostgres(){
        kafkaConsumer=consumerFactoryPostgres();
        kafkaConsumer.subscribe(Arrays.asList(TOPIC));
    }



}
