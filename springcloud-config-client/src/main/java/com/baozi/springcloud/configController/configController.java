package com.baozi.springcloud.configController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.NestingKind;
import java.time.Period;

@RestController
public class configController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return "applicationName:"+applicationName+
                "eurekaServer:"+eurekaServer+
                "port:"+port;
    }
}
