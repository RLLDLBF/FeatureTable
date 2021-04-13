package com.wangshuaizhou.springcloud.controller;

import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureTable2User;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import com.wangshuaizhou.springcloud.service.MainPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MainPageWebController {

    @Resource
    private MainPageService mainPageService;

    @RequestMapping(value = "/mainpage")
    public String MainPage(){
        return "mainpage";
    }

    @RequestMapping(value = "/manager/insert")
    public String ManagerInsert(){
        return "managerinsert";
    }

    @GetMapping(value = "/manager/main")
    public String ManagerMain(){
        return "managermain";
    }

    @GetMapping(value = "/user/main")
    public String UserMain(){
        return "usermain";
    }

    @GetMapping(value="/user/insert")
    public String UserInsert(){
        return "userinsert";
    }

    @RequestMapping(value = "/user/result")
    public String UserResult(@RequestParam(value="Apprealname",defaultValue = "UnknownAppname")String Apprealname,@RequestParam(value = "hidden",defaultValue = "**")String input,HttpSession list_session, Model model){
        List<FeatureWeight> featureWeightList=mainPageService.SelectAllFeatureWeight();
        log.info(input);
        int result = 1;
        if((input.charAt(0)==input.charAt(1)&&input.charAt(0)=='*')||(input.charAt(0)=='*')){
            result=0;
        }else {
            List<FeatureTable2User> featureTableList = new ArrayList<>();
            int starnumber = 0;
            int lastposition = 0;
            String substring;
            char subchar;
            FeatureTable2User featureTable=new FeatureTable2User();
            featureTable.setAppname(Apprealname);
            for (int i = lastposition; i < input.length(); i++) {
                if (input.charAt(i) == '*') {
                    starnumber = (starnumber + 1) % 14;
                    switch (starnumber) {
                        case 1:
                            substring = input.substring(lastposition, i);
                            featureTable.setFuncmodel(substring);
                            lastposition = i + 1;
                            break;
                            case 2:
                                substring = input.substring(lastposition, i);
                                featureTable.setFuncname(substring);
                                lastposition = i + 1;
                                break;
                            case 3:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setBackEndRelated("false");
                                else if (subchar == '1')
                                    featureTable.setBackEndRelated("true");
                                else
                                    featureTable.setBackEndRelated("unknown");
                                lastposition = i + 1;
                                break;
                            case 4:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setInfoTrans("false");
                                else if (subchar == '1')
                                    featureTable.setInfoTrans("true");
                                else
                                    featureTable.setInfoTrans("unknown");
                                lastposition = i + 1;
                                break;
                            case 5:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setDataStore("false");
                                else if (subchar == '1')
                                    featureTable.setDataStore("true");
                                else
                                    featureTable.setDataStore("unknown");
                                lastposition = i + 1;
                                break;
                            case 6:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setSearch("false");
                                else if (subchar == '1')
                                    featureTable.setSearch("true");
                                else
                                    featureTable.setSearch("unknown");
                                lastposition = i + 1;
                                break;
                            case 7:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setAppearance("false");
                                else if (subchar == '1')
                                    featureTable.setAppearance("true");
                                else
                                    featureTable.setAppearance("unknown");
                                lastposition = i + 1;
                                break;
                            case 8:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setPreference("false");
                                else if (subchar == '1')
                                    featureTable.setPreference("true");
                                else
                                    featureTable.setPreference("unknown");
                                lastposition = i + 1;
                                break;
                            case 9:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setFuncExtension("false");
                                else if (subchar == '1')
                                    featureTable.setFuncExtension("true");
                                else
                                    featureTable.setFuncExtension("unknown");
                                lastposition = i + 1;
                                break;
                            case 10:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setTimeliness("false");
                                else if (subchar == '1')
                                    featureTable.setTimeliness("true");
                                else
                                    featureTable.setTimeliness("unknown");
                                lastposition = i + 1;
                                break;
                            case 11:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setSoftwareDev("false");
                                else if (subchar == '1')
                                    featureTable.setSoftwareDev("true");
                                else
                                    featureTable.setSoftwareDev("unknown");
                                lastposition = i + 1;
                                break;
                            case 12:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setNotification("false");
                                else if (subchar == '1')
                                    featureTable.setNotification("true");
                                else
                                    featureTable.setNotification("unknown");
                                lastposition = i + 1;
                                break;
                            case 13:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setDataComputation("false");
                                else if (subchar == '1')
                                    featureTable.setDataComputation("true");
                                else
                                    featureTable.setDataComputation("unknown");
                                lastposition = i + 1;
                                break;
                            case 0:
                                subchar = input.charAt(i - 1);
                                if (subchar == '0')
                                    featureTable.setHotKey("false");
                                else if (subchar == '1')
                                    featureTable.setHotKey("true");
                                else
                                    featureTable.setHotKey("unknown");
                                lastposition = i + 1;
                                featureTableList.add(featureTable);
                                featureTable=new FeatureTable2User();
                                featureTable.setAppname(Apprealname);
                                break;
                            default:
                                break;
                        }
                    }

            }

            /*旧的计算公式，现舍去*/
            /*for (FeatureTable2User featureTable1 : featureTableList) {
                double micro = 0;
                for (FeatureWeight featureWeight : featureWeightList) {
                    if (featureWeight.getFeatureName().equals("BackEndRelated")) {//前提条件必须是yes，若是yes继续计算，否则直接micro为0return
                        if (featureTable1.getBackEndRelated())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("InfoTrans")) {
                        if (featureTable1.getInfoTrans())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("DataStore")) {
                        if (featureTable1.getDataStore())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("Search")) {
                        if (featureTable1.getSearch())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("Appearance")) {
                        if (featureTable1.getAppearance())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("Preference")) {
                        if (featureTable1.getPreference())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("Timeliness")) {
                        if (featureTable1.getTimeliness())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("FuncExtension")) {
                        if (featureTable1.getFuncExtension())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("Notification")) {
                        if (featureTable1.getNotification())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("SoftwareDev")) {
                        if (featureTable1.getSoftwareDev())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("DataComputation")) {
                        if (featureTable1.getDataComputation())
                            micro += featureWeight.getFeatureWeight();
                    }
                    if (featureWeight.getFeatureName().equals("HotKey")) {
                        if (featureTable1.getHotKey())
                            micro += featureWeight.getFeatureWeight();
                    }

                }
                featureTable1.setMicroservice(micro);

            }*/
            for (FeatureTable2User featureTable1 : featureTableList) {
                double micro = 0;
                /*先判断backendrelated先制条件是否满足*/
                if (!featureTable1.getBackEndRelated().equals("true")){
                    featureTable1.setMicroservice("0.0%");
                }
                else{
                    /*DATA模块*/
                    int datacount=0;
                    int othercount=0;
                    int comcount=0;
                    int hybridtimecount=0;
                    int hybridopencount=0;
                    double datamicro=0;
                    double othermicro=0;
                    double commicro=0;
                    double hybridtimemicro=0;
                    double hybridopenmicro=0;
                    for (FeatureWeight featureWeight : featureWeightList) {
                        if (featureWeight.getFeatureName().equals("InfoTrans")) {
                            if (featureTable1.getInfoTrans().equals("true")){
                                datamicro += featureWeight.getFeatureWeight();
                                datacount += 1;
                            }
                            else if (featureTable1.getInfoTrans().equals("unknown")){
                                datamicro += featureWeight.getFeatureWeight()*0.5;
                                datacount += 1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("DataStore")) {
                            if (featureTable1.getDataStore().equals("true")){
                                datamicro += featureWeight.getFeatureWeight();
                                datacount += 1;
                            }
                            else if (featureTable1.getDataStore().equals("unknown")){
                                datamicro += featureWeight.getFeatureWeight()*0.5;
                                datacount += 1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("Search")) {
                            if (featureTable1.getSearch().equals("true")){
                                hybridtimemicro += featureWeight.getFeatureWeight();
                                hybridtimecount += 1;
                            }
                            else if (featureTable1.getSearch().equals("unknown")){
                                hybridtimemicro += featureWeight.getFeatureWeight()*0.5;
                                hybridtimecount += 1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("Appearance")) {
                            if (featureTable1.getAppearance().equals("true")) {
                                datamicro += featureWeight.getFeatureWeight();
                                datacount+=1;
                            }
                            else if (featureTable1.getAppearance().equals("unknown")) {
                                datamicro += featureWeight.getFeatureWeight()*0.5;
                                datacount+=1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("Preference")) {
                            if (featureTable1.getPreference().equals("true")){
                                datamicro += featureWeight.getFeatureWeight();
                                datacount += 1;
                            }
                            else if (featureTable1.getPreference().equals("unknown")){
                                datamicro += featureWeight.getFeatureWeight()*0.5;
                                datacount += 1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("Timeliness")) {
                            if (featureTable1.getTimeliness().equals("true")){
                                hybridtimemicro += featureWeight.getFeatureWeight();
                                hybridtimecount+=1;
                            }
                            else if (featureTable1.getTimeliness().equals("unknown")){
                                hybridtimemicro += featureWeight.getFeatureWeight()*0.5;
                                hybridtimecount+=1;
                            }    
                        }
                        if (featureWeight.getFeatureName().equals("FuncExtension")) {
                            if (featureTable1.getFuncExtension().equals("true")){
                                hybridopenmicro += featureWeight.getFeatureWeight();
                                hybridopencount+=1;
                            }
                            else if (featureTable1.getFuncExtension().equals("unknown")){
                                hybridopenmicro += featureWeight.getFeatureWeight()*0.5;
                                hybridopencount+=1;
                            }    
                        }
                        if (featureWeight.getFeatureName().equals("Notification")) {
                            if (featureTable1.getNotification().equals("true")){
                                datamicro += featureWeight.getFeatureWeight();
                                datacount+=1;
                            }
                             else if (featureTable1.getNotification().equals("unknown")){
                                datamicro += featureWeight.getFeatureWeight()*0.5;
                                datacount+=1;
                            }   
                        }
                        if (featureWeight.getFeatureName().equals("SoftwareDev")) {
                            if (featureTable1.getSoftwareDev().equals("true")){
                                hybridopenmicro += featureWeight.getFeatureWeight();
                                hybridopencount+=1;
                            }
                            else if (featureTable1.getSoftwareDev().equals("unknown")){
                                hybridopenmicro += featureWeight.getFeatureWeight()*0.5;
                                hybridopencount+=1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("DataComputation")) {
                            if (featureTable1.getDataComputation().equals("true")){
                                commicro += featureWeight.getFeatureWeight();
                                comcount+=1;
                            }
                            else if (featureTable1.getDataComputation().equals("unknown")){
                                commicro += featureWeight.getFeatureWeight()*0.5;
                                comcount+=1;
                            }
                        }
                        if (featureWeight.getFeatureName().equals("HotKey")) {
                            if (featureTable1.getHotKey().equals("true")){
                                othermicro += featureWeight.getFeatureWeight();
                                othercount+=1;
                            }
                            else if (featureTable1.getHotKey().equals("unknown")){
                                othermicro += featureWeight.getFeatureWeight()*0.5;
                                othercount+=1;
                            }    
                        }

                    }
                    if(hybridopencount>0){
                        hybridopenmicro=(hybridopenmicro/hybridopencount)*100;
                    }
                    if(hybridtimecount>0){
                        hybridtimemicro=(hybridtimemicro/hybridtimecount)*100;
                    }
                    if(datacount>0){
                        datamicro=(datamicro/datacount)*100;
                    }
                    if(othercount>0){
                        othermicro=(othermicro/othercount)*100;
                    }
                    if(comcount>0){
                        commicro=(commicro/comcount)*100;
                    }
                    micro=hybridopenmicro+hybridtimemicro+datamicro+commicro+othermicro;
                    log.info(String.valueOf(micro)+"="+String.valueOf(hybridopenmicro)+"+"+String.valueOf(hybridtimemicro)+"+"+String.valueOf(datamicro)+"+"+String.valueOf(commicro)+"+"+String.valueOf(othermicro));
                    BigDecimal bg = new BigDecimal(micro);
                    double f1 = bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    featureTable1.setMicroservice(String.valueOf(f1)+"%");
                }
            }

            String temp="";
            String storage="";
            temp="Appname,";
            storage=storage.concat(temp);
            temp="Funcmodel,";
            storage=storage.concat(temp);
            temp="Funcname,";
            storage=storage.concat(temp);
            temp="Microservice,";
            storage=storage.concat(temp);
            temp="BackEndRelated,";
            storage=storage.concat(temp);
            temp="InfoTrans,";
            storage=storage.concat(temp);
            temp="DataStore,";
            storage=storage.concat(temp);
            temp="Search,";
            storage=storage.concat(temp);
            temp="Appearance,";
            storage=storage.concat(temp);
            temp="Preference,";
            storage=storage.concat(temp);
            temp="FuncExtension,";
            storage=storage.concat(temp);
            temp="Timeliness,";
            storage=storage.concat(temp);
            temp="SoftwareDev,";
            storage=storage.concat(temp);
            temp="Notification,";
            storage=storage.concat(temp);
            temp="DataComputation,";
            storage=storage.concat(temp);
            temp="HotKey,\n";
            storage=storage.concat(temp);
            
            for (FeatureTable2User featureTable1 : featureTableList){
                temp=featureTable1.getAppname();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getFuncmodel();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getFuncname();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getMicroservice();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getBackEndRelated();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getInfoTrans();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getDataStore();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getSearch();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getAppearance();
                storage=storage.concat(temp);
                storage=storage.concat(",");

                temp=featureTable1.getPreference();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getFuncExtension();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getTimeliness();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getSoftwareDev();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getNotification();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getDataComputation();
                storage=storage.concat(temp);
                storage=storage.concat(",");
                
                temp=featureTable1.getHotKey();
                storage=storage.concat(temp);
                storage=storage.concat(",\n");
            }
            model.addAttribute("storagefile",storage);
            list_session.setAttribute("featuretablelist", featureTableList);
            log.info(featureTableList.toString());
        }



        return "userresult";
    }
}
