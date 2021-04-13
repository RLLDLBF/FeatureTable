package com.wangshuaizhou.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StatisticsServer8005 {
    public static void main(String[] args){
        SpringApplication.run(StatisticsServer8005.class,args);
    }
}
