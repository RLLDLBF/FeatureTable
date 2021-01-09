package com.nju.springcloud.controller;

import com.nju.springcloud.entities.CommonResult;
import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class DeliveryController {
    @Resource
    private DeliveryService deliveryService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/delivery/updatecargolocation")
    public CommonResult UpdateCargoLocation(CargoVersion2 cargo){
        int result = deliveryService.UpdateCargoLocation(cargo);
        log.info("************New result: "+result+"************");
        if (result>0){  //success
            return new CommonResult(200,"Update Successfully, servePort: "+serverPort,result);
        }else {
            return new CommonResult(444,"Update Unsuccessfully",null);
        }
    }

}

