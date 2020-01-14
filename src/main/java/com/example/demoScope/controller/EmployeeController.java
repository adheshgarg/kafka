package com.example.demoScope.controller;

import com.example.demoScope.service.impl.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class EmployeeController {

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(){
        this.producerService.sendMessage();
    }


}
