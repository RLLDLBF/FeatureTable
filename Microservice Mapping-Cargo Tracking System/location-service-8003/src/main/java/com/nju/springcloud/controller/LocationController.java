package com.nju.springcloud.controller;

import com.nju.springcloud.entities.CommonResult;

import com.nju.springcloud.entities.locationVersion2.LocationVersion2;
import com.nju.springcloud.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class LocationController {
    @Resource
    private LocationService locationService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/location/createlocation")
    public CommonResult CreateLocation(LocationVersion2 location){
        int result = locationService.CreateLocation(location);
        log.info("************New location: "+result+"************");
        if (result>0){
            return new CommonResult(200,"Insert Successfully, servePort: "+serverPort,result);
        }else{
            return new CommonResult(444,"Insert Unsuccessfully",null);
        }
    }
}
