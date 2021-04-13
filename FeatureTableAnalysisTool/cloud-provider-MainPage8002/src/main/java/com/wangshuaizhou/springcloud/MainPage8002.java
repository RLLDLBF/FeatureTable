package com.wangshuaizhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainPage8002 {
    public static void main(String[] args){
        SpringApplication.run(MainPage8002.class,args);
    }
}
