package com.example.demoScope.service.kafka;

import com.example.demoScope.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
//import org.apache.kafka.common.serialization.Serde;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class KafkaSerializer implements Serializer {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void configure(Map map, boolean b) { }

    @Override
    public byte[] serialize(String arg0, Employee arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }

    @Override public void close() {
    }
}