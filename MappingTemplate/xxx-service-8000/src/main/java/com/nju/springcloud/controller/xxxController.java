package com.nju.springcloud.controller;

import com.nju.springcloud.service.xxxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * To provide URL for service callers
 */

@RestController
@Slf4j
public class xxxController {

    @Resource
    private xxxService xxxservice;

    @Value("${server.port}")
    private String serverPort;

}
