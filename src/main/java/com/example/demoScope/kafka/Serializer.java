package com.example.demoScope.kafka;

import com.example.demoScope.entity.Employee;

public interface Serializer {
    public byte[] serialize(String s, Employee o);

}
