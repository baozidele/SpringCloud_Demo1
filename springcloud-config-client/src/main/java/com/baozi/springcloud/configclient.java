package com.baozi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

public class configclient {
    public static void main(String[] args) {
        SpringApplication.run(configclient.class,args);
    }
}
