package com.example.demoScope.repository;

import com.example.demoScope.entity.Employee;

import java.io.Closeable;
import java.util.Map;

public interface Serializer extends Closeable {

    void configure(Map<String, ?> var1, boolean var2);

    byte[] serialize(String var1, Employee var2);

    void close();

}
