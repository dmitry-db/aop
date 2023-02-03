package com.example.aspect.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String takeName(String name) {

        if ("tom".equals(name)) {
            throw new RuntimeException();
        }
        return name;
    }

    public String findName(String name) {
        return name;
    }
}
