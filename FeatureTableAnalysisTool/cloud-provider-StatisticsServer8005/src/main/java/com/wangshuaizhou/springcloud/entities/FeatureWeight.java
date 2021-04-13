package com.wangshuaizhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureWeight {
    private Integer id;
    private String FeatureName;
    private Double FeatureWeight;
}
