package com.example.demoScope.controller;

import com.example.demoScope.service.impl.*;
import com.example.demoScope.service.impl.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/start")
public class EmployeeController extends Thread{

    @Autowired
    @Qualifier(value = "MyThreadCSV")
    MyThreadCSV myThreadCSV;
    @Autowired
    @Qualifier(value = "MyThreadJSON")
    MyThreadJSON myThreadJSON;
    @Autowired
    @Qualifier(value = "MyThreadXML")
    MyThreadXML myThreadXML;
    @Autowired
    @Qualifier(value = "ConsumerMongo")
    ConsumerMongo consumerMongo;
    @Autowired
    @Qualifier(value = "ConsumerPostgres")
    ConsumerPostgres consumerPostgres;

    Thread[] thread = new Thread[5];

    @PostConstruct
    public void threadStart(){
        myThreadCSV = new MyThreadCSV();
        thread[0] = myThreadCSV;
        myThreadJSON = new MyThreadJSON();
        thread[1] = myThreadJSON;
        myThreadXML = new MyThreadXML();
        thread[2] = myThreadXML;
        for(int index=0;index<3;index++){
            thread[index].start();
        }
        for(int index=0;index<3;index++){
            try {
                thread[index].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        consumerMongo = new ConsumerMongo();
        thread[3] = consumerMongo;
        consumerPostgres = new ConsumerPostgres();
        thread[4] = consumerPostgres;

        for(int index=3;index<5;index++){
            thread[index].start();
        }
        for(int index=3;index<5;index++) {
            try {
                thread[index].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producerService.sendMessage(message);
    }


}
