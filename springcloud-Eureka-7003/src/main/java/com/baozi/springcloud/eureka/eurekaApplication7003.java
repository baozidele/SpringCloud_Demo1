package com.baozi.springcloud.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class eurekaApplication7003 {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication7003.class, args);
    }
}

