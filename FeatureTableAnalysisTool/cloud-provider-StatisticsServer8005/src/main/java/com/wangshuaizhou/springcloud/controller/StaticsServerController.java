package com.wangshuaizhou.springcloud.controller;

import com.wangshuaizhou.springcloud.entities.CommonResult;
import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import com.wangshuaizhou.springcloud.service.StaticsServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class StaticsServerController {

    @Resource
    private StaticsServerService staticsServerService;

    @GetMapping(value = "/statistics/getweight")
    public CommonResult SelectAllFeatureWeight(){
        List<FeatureWeight> featureWeightList=staticsServerService.SelectAllFeatureWeight();
        if(!featureWeightList.isEmpty()){
            return new CommonResult(200,"select successfully",featureWeightList);
        }
        else {
            return new CommonResult(400,"select failed",null);
        }
    }
    @GetMapping(value = "/statistics/feedback")
    public CommonResult FeedBack(){
        return new CommonResult(200,"click 确认 back to main",null);
    }

    /*测试url如下*/
    /*http://localhost:8005/statistics/insert?Appname=test&Funcname=test&Microservice=0&BackEndRelated=0&InfoTrans=0&DataStore=0&Search=0&Appearance=0&Preference=0&FuncExtension=0&Timeliness=0&SoftwareDev=0&Notification=0&DataComputation=0&HotKey=0*/
    /*注：经过测试发现featuretable数据库无主键，应把id设为主键*/
    @GetMapping(value = "/statistics/insert")
    public CommonResult InsertFeatureTable(FeatureTable featureTable){
        int result = staticsServerService.InsertFeatureTable(featureTable);
        if(result>0){
            List<FeatureWeight> featureWeightList=staticsServerService.SelectAllFeatureWeight();
            for(FeatureWeight featureWeight:featureWeightList){
                int ret = staticsServerService.UpdateFeatureWeightByMysql(featureWeight.getFeatureName());
            }
            List<FeatureWeight> featureWeightList2=staticsServerService.SelectAllFeatureWeight();
            return new CommonResult(200,"插入数据成功",featureWeightList2);
        }else{
            return new CommonResult(400,"插入数据失败",null);
        }
    }

    /*测试url如下*/
    /*http://localhost:8005/statistics/updateweight?FeatureWeight=0.5&FeatureName=Search*/
    @GetMapping(value = "/statistics/updateweightbyinput")
    public CommonResult UpdateWeight(FeatureWeight featureWeight){
        int result = staticsServerService.UpdateFeatureWeight(featureWeight);
        if(result>0){
            return new CommonResult(200,"更新数据成功",result);
        }else{
            return new CommonResult(400,"更新数据失败",null);
        }
    }

    /*测试url如下*/
    /*http://localhost:8005/statistics/updateweightbymysql?featureweight_name=InfoTrans*/
    @GetMapping(value = "/statistics/updateweightbymysql")
    CommonResult UpdateWeightByMysql(String featureweight_name){
        log.info(featureweight_name);
        int result = staticsServerService.UpdateFeatureWeightByMysql(featureweight_name);
        if(result>0){
            return new CommonResult(200,"更新数据成功",result);
        }else{
            return new CommonResult(400,"更新数据失败",null);
        }
    }
}
