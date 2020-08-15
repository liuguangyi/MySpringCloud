package com.consumer.userconsumer;

import com.hoxton.user_api.UserApi;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserBack implements UserContriller {
    @Override
    public String alive() {
        return "降级";
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }
}
