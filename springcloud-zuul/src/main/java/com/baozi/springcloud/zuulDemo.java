package com.baozi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class zuulDemo {
    public static void main(String[] args) {
        SpringApplication.run(zuulDemo.class,args);
    }
}
