package com.example.demoScope.controller;

import com.example.demoScope.service.EmployeeServices;
import com.example.demoScope.service.impl.MyThreadCSV;
import com.example.demoScope.service.impl.MyThreadJSON;
import com.example.demoScope.service.impl.MyThreadXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/start")
public class EmployeeController extends Thread{

    @Autowired
    EmployeeServices employeeServices;

    MyThreadCSV myThreadCSV;
    MyThreadJSON myThreadJSON;
    MyThreadXML myThreadXML;

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
            try {
                thread[index].start();
            } catch (Exception e) {
                e.printStackTrace();
            }
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
