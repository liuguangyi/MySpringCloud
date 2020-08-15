package com.consumer.userconsumer;


import com.consumer.userconsumer.UserContriller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    UserContriller userContriller;

    @GetMapping("/alive")
    public String alive(){

        return userContriller.alive();
    }

}
