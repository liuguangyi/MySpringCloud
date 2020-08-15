package com.hoxton.useradmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAdminServer
@SpringBootApplication
public class UserAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);
    }

    @Bean
    public DingDingNotifier dingDingNotifier(InstanceRepository repository) {
        return new DingDingNotifier(repository);
    }
}
