package com.provider.userprovider.controller;

import com.hoxton.user_api.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController implements UserApi {

    @Value("${server.port}")
    String port;
    @Override
    public String alive() {
        System.out.println("访问alive"+port);
//        int i=1/0;
//        System.out.println("访问alive"+port);
        return "alive:"+port;
    }

}
