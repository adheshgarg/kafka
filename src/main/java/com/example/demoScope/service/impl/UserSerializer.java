package com.example.demoScope.service.impl;

import com.example.demoScope.entity.Employee;
import com.example.demoScope.repository.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserSerializer implements Serializer {


        @Override public void configure(Map<String, ?> map, boolean b) {

        }

        @Override public byte[] serialize(String arg0, Employee arg1) {
            byte[] retVal = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                retVal = objectMapper.writeValueAsString(arg1).getBytes();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return retVal;
        }

        @Override public void close() {

        }



}
