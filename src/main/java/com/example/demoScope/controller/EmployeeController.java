package com.example.demoScope.controller;

import com.example.demoScope.service.impl.*;
import com.example.demoScope.service.impl.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/start")
public class EmployeeController extends Thread{

    //@Autowired
    //private ProducerService producerService;

    @Autowired
    @Qualifier(value = "MyThreadCSV")
    MyThreadCSV myThreadCSV;
    @Autowired
    @Qualifier(value = "MyThreadJSON")
    MyThreadJSON myThreadJSON;
    @Autowired
    @Qualifier(value = "MyThreadXML")
    MyThreadXML myThreadXML;


    Thread[] thread = new Thread[3];

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

    }
}
