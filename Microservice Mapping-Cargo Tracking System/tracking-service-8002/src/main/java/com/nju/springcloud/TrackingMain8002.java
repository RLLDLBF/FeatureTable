package com.nju.springcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nju.springcloud.dao")
public class TrackingMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(TrackingMain8002.class,args);
    }
}
