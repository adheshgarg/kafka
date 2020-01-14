package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.entity.EmployeeMongo;
import com.example.demoScope.entity.EmployeePostgres;
import com.example.demoScope.repository.EmployeeMongoRepository;
import com.example.demoScope.repository.EmployeePostgresRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerService {

    private static final String TOPIC = "Kafka_Employee_json";

    private static int counter = 0;
    @Autowired
    @Qualifier("EmployeePostgresRepository")
    EmployeePostgresRepository employeePostgresRepository;


    @Autowired
    @Qualifier("EmployeeMongoRepository")
    EmployeeMongoRepository employeeMongoRepository;

    @KafkaListener(topics="Kafka_Json_emp",groupId = "group_id",containerFactory = "employeeKafkaListenerContainerFactory")
    @KafkaListener(topics = "Kafka_Employee_json", groupId = "group_id")
    public void consume(Employee employee) {
        System.out.println(employee.toString());
        if (counter < 150) {
            EmployeePostgres employeePostgres = new EmployeePostgres();
            BeanUtils.copyProperties(employee, employeePostgres);
            employeePostgresRepository.save(employeePostgres);
            counter++;
        }
        else{
            System.out.println(employee.toString());
            if (counter < 150) {
                EmployeeMongo employeeMongo = new EmployeeMongo();
                BeanUtils.copyProperties(employee, employeeMongo);
                employeeMongoRepository.save(employeeMongo);
                System.out.println("Writing");
                counter++;

            }
        }
    }


}
