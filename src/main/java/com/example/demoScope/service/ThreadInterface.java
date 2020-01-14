package com.example.demoScope.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ThreadInterface{

    void read() throws IOException;
}
