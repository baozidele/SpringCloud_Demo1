package com.baozi.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import javax.naming.Name;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.baozi.springcloud.serive")
@ComponentScan("com.baozi.springcloud")
public class FeignconsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignconsumerApplication.class,args);
    }
}
