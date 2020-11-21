package com.baozi.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class config {

//    @Bean
    public IRule get(){
        return new ruleDemo();
    }
}
