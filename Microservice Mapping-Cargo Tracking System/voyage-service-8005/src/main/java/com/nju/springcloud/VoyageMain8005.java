package com.nju.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nju.springcloud.dao")
public class VoyageMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(VoyageMain8005.class,args);
    }
}
