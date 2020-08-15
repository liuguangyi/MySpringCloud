package com.consumer.userconsumer;

import com.hoxton.user_api.UserApi;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class UserBackFactory implements FallbackFactory<UserContriller> {

    @Override
    public UserContriller create(Throwable cause) {
        return new UserContriller() {
            @Override
            public Map<Integer, String> getMap(Integer id) {
                return null;
            }

            @Override
            public String alive() {
                System.out.println(cause.getLocalizedMessage());

//                cause.printStackTrace();
                if (cause instanceof FeignException.InternalServerError) {
                    return "500";
                }
                return ToStringBuilder.reflectionToString(cause);
            }
        };
    }
}
