package com.nju.springcloud.controller;


import com.nju.springcloud.entities.CommonResult;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.TrackingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TrackingController {
    @Resource
    private TrackingService trackingService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/tracking/viewtracking/{trackingId}")
    public CommonResult ViewTracking(@PathVariable("trackingId")String trackingId){
        CargoVersion2 cargo = trackingService.ViewTracking(trackingId);
        log.info("************Result: "+cargo+"************");
        if(cargo!=null){
            return new CommonResult(200,"Cargo: ",cargo);
        }else {
            return new CommonResult(444,"Fail to find the cargo of "+trackingId,null);
        }
    }
}
