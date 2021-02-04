package com.yash.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocalCache {

    private String authorization;

    private String namespace;

    private int lastVersion;

    private Map<String, Map<String,String>> secretMap;

    public Map<String, Map<String, String>> getSecretMap() {
        if(secretMap == null){
            secretMap = new HashMap<>();
        }
        return secretMap;
    }

    public void setSecretMap(Map<String, Map<String, String>> secretMap) {
        this.secretMap = secretMap;
    }

    public int getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(int lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
