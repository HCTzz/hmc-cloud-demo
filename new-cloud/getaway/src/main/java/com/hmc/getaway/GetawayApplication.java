package com.hmc.getaway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication(scanBasePackages = "com.hmc.getaway")
@EnableDiscoveryClient
public class GetawayApplication {

    public static void main(String[] args) {
        System.setProperty("spring.main.allow-bean-definition-overriding","true");
        SpringApplication.run(GetawayApplication.class, args);
    }

}
