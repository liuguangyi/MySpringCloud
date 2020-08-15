package com.hoxton.userzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@EnableZuulProxy
@SpringBootApplication
public class UserZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserZuulApplication.class, args);
    }

}
