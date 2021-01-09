package com.nju.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nju.springcloud.dao")
public class DeliveryMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryMain8008.class,args);
    }
}
