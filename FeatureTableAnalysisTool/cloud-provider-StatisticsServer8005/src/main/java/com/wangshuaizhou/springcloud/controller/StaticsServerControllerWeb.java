package com.wangshuaizhou.springcloud.controller;

import com.wangshuaizhou.springcloud.entities.CommonResult;
import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import com.wangshuaizhou.springcloud.service.StaticsServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class StaticsServerControllerWeb {

    @Resource
    private StaticsServerService staticsServerService;

    @GetMapping(value = "/statistics/getweightweb")
    public String SelectAllFeatureWeight(HttpSession list_session, Model is_empty_model){
        List<FeatureWeight> featureWeightList=staticsServerService.SelectAllFeatureWeight();
        if(!featureWeightList.isEmpty()){
            for(FeatureWeight featureWeight:featureWeightList){
                BigDecimal bg = new BigDecimal(featureWeight.getFeatureWeight()*100);
                double f1 = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                featureWeight.setFeatureWeight(f1);
            }
            is_empty_model.addAttribute("result","success");
            list_session.setAttribute("featurelist",featureWeightList);

            //return new CommonResult(200,"select successfully",featureWeightList);
        }
        else {
            is_empty_model.addAttribute("result","fail");
            list_session.setAttribute("featurelist",featureWeightList);
            //return new CommonResult(400,"select failed",null);
        }
        return "GetWeightWeb";
    }

    @RequestMapping(value = "/statistics/feedbackweb")
    public String InsertFeedBack(@RequestParam(value = "hidden",defaultValue = "NULL") String input, Model model){
        //int result = staticsServerService.InsertFeatureTable(featureTable);
        log.info(input);
        int result = 1;
        if((input.charAt(0)==input.charAt(1)&&input.charAt(0)=='*')||(input.charAt(0)=='*')){
            result=0;
        }else{
            List<FeatureTable> featureTableList=new ArrayList<>();
            int starnumber=0;
            int lastposition=0;
            String substring;
            char subchar;
            FeatureTable featureTable=new FeatureTable();
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)=='*'){
                    starnumber=(starnumber+1)%15;
                    switch (starnumber){
                        case 1:substring=input.substring(lastposition,i);
                            featureTable.setAppname(substring);
                            lastposition=i+1;
                            break;
                        case 2:substring=input.substring(lastposition,i);
                            featureTable.setFuncname(substring);
                            lastposition=i+1;
                            break;
                        case 3:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setMicroservice(false);
                            else
                                featureTable.setMicroservice(true);
                            lastposition=i+1;
                            break;
                        case 4:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setBackEndRelated(false);
                            else
                                featureTable.setBackEndRelated(true);
                            lastposition=i+1;
                            break;
                        case 5:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setInfoTrans(false);
                            else
                                featureTable.setInfoTrans(true);
                            lastposition=i+1;
                            break;
                        case 6:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setDataStore(false);
                            else
                                featureTable.setDataStore(true);
                            lastposition=i+1;
                            break;
                        case 7:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setSearch(false);
                            else
                                featureTable.setSearch(true);
                            lastposition=i+1;
                            break;
                        case 8:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setAppearance(false);
                            else
                                featureTable.setAppearance(true);
                            lastposition=i+1;
                            break;
                        case 9:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setPreference(false);
                            else
                                featureTable.setPreference(true);
                            lastposition=i+1;
                            break;
                        case 10:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setFuncExtension(false);
                            else
                                featureTable.setFuncExtension(true);
                            lastposition=i+1;
                            break;
                        case 11:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setTimeliness(false);
                            else
                                featureTable.setTimeliness(true);
                            lastposition=i+1;
                            break;
                        case 12:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setSoftwareDev(false);
                            else
                                featureTable.setSoftwareDev(true);
                            lastposition=i+1;
                            break;
                        case 13:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setNotification(false);
                            else
                                featureTable.setNotification(true);
                            lastposition=i+1;
                            break;
                        case 14:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setDataComputation(false);
                            else
                                featureTable.setDataComputation(true);
                            lastposition=i+1;
                            break;
                        case 0:subchar=input.charAt(i-1);
                            if(subchar=='0')
                                featureTable.setHotKey(false);
                            else
                                featureTable.setHotKey(true);
                            lastposition=i+1;
                            featureTableList.add(featureTable);
                            featureTable=new FeatureTable();
                            break;
                        default:break;
                    }
                }
            }
            for(FeatureTable featureTable1:featureTableList){
                log.info(featureTable1.toString());
                int res=staticsServerService.InsertFeatureTable(featureTable1);
                if(res<=0){
                    result=0;
                    break;
                }
                else{
                    result=res;
                }
            }
        }

        if(result>0){
            model.addAttribute("result","插入数据成功！");
        }else{
            model.addAttribute("result","插入数据失败！");
        }
        return "FeedBackWeb";
    }

    @GetMapping(value = "/statistics/updateweightweb")
    public String UpdateWeightWeb(HttpSession list_session, Model is_empty_model){
        List<FeatureWeight> featureWeightList=staticsServerService.SelectAllFeatureWeight();
        if(!featureWeightList.isEmpty()){
            for(FeatureWeight featureWeight:featureWeightList){
                int ret=staticsServerService.UpdateFeatureWeightByMysql(featureWeight.getFeatureName());
                BigDecimal bg = new BigDecimal(featureWeight.getFeatureWeight()*100);
                double f1 = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                featureWeight.setFeatureWeight(f1);
            }
            is_empty_model.addAttribute("result","success");
            list_session.setAttribute("featurelist",featureWeightList);

            //return new CommonResult(200,"select successfully",featureWeightList);
        }
        else {
            is_empty_model.addAttribute("result","fail");
            list_session.setAttribute("featurelist",featureWeightList);
            //return new CommonResult(400,"select failed",null);
        }
        return "UpdateweightWeb";
    }
}
