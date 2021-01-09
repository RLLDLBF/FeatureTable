package com.nju.springcloud.controller;

import com.nju.springcloud.entities.CommonResult;
import com.nju.springcloud.entities.voyageVersion2.CarrierMovementVersion2;
import com.nju.springcloud.entities.voyageVersion2.VoyageVersion2;
import com.nju.springcloud.service.VoyageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class VoyageController {
    @Resource
    private VoyageService voyageService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/voyage/createvoyage")
    public CommonResult CreateVoyage(VoyageVersion2 voyage){
        int result = voyageService.CreateVoyage(voyage);
        log.info("************New voyage: "+result+"************");
        if (result>0){
            return new CommonResult(200,"Insert Successfully, servePort: "+serverPort,result);
        }else{
            return new CommonResult(444,"Insert Unsuccessfully",null);
        }
    }

    @PostMapping(value = "/voyage/addcarriermovement")
    public CommonResult AddCarrierMovement(CarrierMovementVersion2 carrierMovement){
        int result = voyageService.AddCarrierMovement(carrierMovement);
        log.info("************New carrierMovement: "+result+"************");
        if (result>0){
            return new CommonResult(200,"Insert Successfully, servePort: "+serverPort,result);
        }else{
            return new CommonResult(444,"Insert Unsuccessfully",null);
        }
    }

}
