package com.yash.model;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RecorderStats {
    Map<String,Map<String,String>> envChange = new HashMap<>();
    Map<String,Map<String,String>> resourceChanges = new HashMap<>();

    public Map<String, Map<String, String>> getEnvChange() {
        return envChange;
    }

    public void setEnvChange(String key,String oldV,String newV) {
        Map<String, String> valueMap = this.envChange.get(key);
        if(valueMap == null){
            valueMap = new HashMap<>();
            this.envChange.put(key,valueMap);
        }
        if(!StringUtils.isEmpty(oldV)) {
            valueMap.put("Source", oldV);
        }
        if(!StringUtils.isEmpty(newV)) {
            valueMap.put("Target", newV);
        }
    }


    public Map<String, Map<String, String>> getResourceChanges() {
        return resourceChanges;
    }

    public void setResourceChanges(String key,String oldV,String newV) {
        Map<String, String> valueMap = this.resourceChanges.get(key);
        if(valueMap == null){
            valueMap = new HashMap<>();
            this.resourceChanges.put(key,valueMap);
        }
        if(!StringUtils.isEmpty(oldV)) {
            valueMap.put("Source", oldV);
        }
        if(!StringUtils.isEmpty(newV)) {
            valueMap.put("Target", newV);
        }
    }
}
