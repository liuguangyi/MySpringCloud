package com.hoxton.user_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@RequestMapping("/rest")
public interface UserApi {

    @GetMapping("/user/alive")
    public String alive();

}
