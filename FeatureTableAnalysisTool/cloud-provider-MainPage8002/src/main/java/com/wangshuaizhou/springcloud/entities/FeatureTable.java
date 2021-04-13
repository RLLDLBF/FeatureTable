package com.wangshuaizhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureTable {
    private Long id;
    private String Appname;
    private String Funcname;
    private Double Microservice;
    private Boolean BackEndRelated;
    private Boolean InfoTrans;
    private Boolean DataStore;
    private Boolean Search;
    private Boolean Appearance;
    private Boolean Preference;
    private Boolean FuncExtension;
    private Boolean Timeliness;
    private Boolean SoftwareDev;
    private Boolean Notification;
    private Boolean DataComputation;
    private Boolean HotKey;
}