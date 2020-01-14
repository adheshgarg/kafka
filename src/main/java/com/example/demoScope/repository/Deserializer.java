package com.example.demoScope.repository;

import com.example.demoScope.entity.Employee;

import java.io.Closeable;
import java.util.Map;

public interface Deserializer extends Closeable {

    void configure(Map<String, ?> var1, boolean var2);

    Employee deserialize(String var1, byte[] var2);

    void close();
}
