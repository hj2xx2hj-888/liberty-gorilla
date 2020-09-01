package com.liberty.gorilla.application.service.impl;

import com.liberty.gorilla.application.service.TestService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        return "Hello World";
    }
}
