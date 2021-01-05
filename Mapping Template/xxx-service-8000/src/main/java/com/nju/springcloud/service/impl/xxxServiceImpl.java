package com.nju.springcloud.service.impl;

import com.nju.springcloud.dao.xxxDao;
import com.nju.springcloud.service.xxxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Realization of service
 */

@Service
public class xxxServiceImpl implements xxxService {

    /**
     * call functions in dao
     */
    @Resource
    private xxxDao xxxdao;

}
