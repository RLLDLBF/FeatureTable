package com.nju.springcloud.controller;

import com.nju.springcloud.entities.CommonResult;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.CargoService;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class CargoController {
    @Resource
    private CargoService cargoService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/cargo/listallcargos")
    public CommonResult ListAllCargos(){
        List<CargoVersion2> cargoList = cargoService.ListAllCargos();
        log.info("************Result: "+cargoList+"************");
        if(cargoList!=null){
            return new CommonResult(200,"Cargos: ",cargoList);
        }else {
            return new CommonResult(444,"Fail to find the cargos",null);
        }
    }

    @GetMapping(value = "/cargo/viewdetailsforcargo/{trackingId}")
    public CommonResult ViewDetailsForCargo(@PathVariable("trackingId") String trackingId){
        CargoVersion2 cargo = cargoService.ViewDetailsForCargo(trackingId);
        log.info("************Result: "+cargo+"************");
        if(cargo!=null){
            return new CommonResult(200,"Cargo: ",cargo);
        }else {
            return new CommonResult(444,"Fail to find the cargo of "+trackingId,null);
        }
    }

    @PostMapping(value = "/cargo/bookcargo")
    public CommonResult BookCargo(CargoVersion2 cargo){
        int result = cargoService.BookCargo(cargo);
        log.info("************New account: "+result+"************");
        if (result>0){  //success
            return new CommonResult(200,"Insert Successfully, servePort: "+serverPort,result);
        }else {
            return new CommonResult(444,"Insert Unsuccessfully",null);
        }
    }

    @PostMapping(value = "/cargo/changecargodestination")
    public CommonResult ChangeCargoDestination(CargoVersion2 cargo){
        int result = cargoService.ChangeCargoDestination(cargo);
        log.info("************New result: "+result+"************");
        if (result>0){  //success
            return new CommonResult(200,"Update Successfully, servePort: "+serverPort,result);
        }else {
            return new CommonResult(444,"Update Unsuccessfully",null);
        }
    }

}


