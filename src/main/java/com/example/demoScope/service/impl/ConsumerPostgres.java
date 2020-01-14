package com.example.demoScope.service.impl;
import com.example.demoScope.dto.EmployeeDTO;
import com.example.demoScope.entity.EmployeePostgres;
import com.example.demoScope.repository.EmployeePostgresRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerPostgres extends Thread {


    @Autowired
    @Qualifier("EmployeePostgresRepository")
    EmployeePostgresRepository employeePostgresRepository;


    @KafkaListener(topics = "stream", groupId = "smh")
    public void consume(String msg) {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        try {
            employeeDTO = objectMapper.readValue(msg, EmployeeDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employeeDTO.toString());
        EmployeePostgres employeePostgres = new EmployeePostgres();
        BeanUtils.copyProperties(employeeDTO, employeePostgres);
        employeePostgresRepository.save(employeePostgres);
    }
    @Override
    public void run() {
        super.run();
    }

}
