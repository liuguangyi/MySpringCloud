package com.consumer.userconsumer;

import com.consumer.userconsumer.UserBack;
import com.hoxton.user_api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "provider" ,fallbackFactory = UserBackFactory.class)
public interface UserContriller extends UserApi {

    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);
}
