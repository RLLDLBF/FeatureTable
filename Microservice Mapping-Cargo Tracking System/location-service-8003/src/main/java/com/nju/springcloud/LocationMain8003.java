package com.nju.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nju.springcloud.dao")
public class LocationMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(LocationMain8003.class,args);
    }
}
