package com.wangshuaizhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureTable2User {
    private Long id;
    private String Appname;
    private String Funcmodel;
    private String Funcname;
    private String Microservice;
    private String BackEndRelated;
    private String InfoTrans;
    private String DataStore;
    private String Search;
    private String Appearance;
    private String Preference;
    private String FuncExtension;
    private String Timeliness;
    private String SoftwareDev;
    private String Notification;
    private String DataComputation;
    private String HotKey;
}
