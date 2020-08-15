package com.provider.userprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/alive")
    public String alive(){
        return "ok";
    }
}
