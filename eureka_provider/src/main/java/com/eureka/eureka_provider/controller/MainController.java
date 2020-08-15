package com.eureka.eureka_provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("/hello")
    public String getHello(){

        return port;
    }
}
