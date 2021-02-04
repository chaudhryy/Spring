package nz.co.spark.intg.ocp.utility.cache;

import nz.co.spark.intg.ocp.utility.ocp.utils.DbUtil;
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

    public void setValueInSecretMap(String secretName, String key,String value) {
        if(this.secretMap == null){
            this.secretMap = new HashMap<>();
        }
        ;
        if(secretMap.get(secretName)== null){
            Map<String, String> keyMap = new HashMap<>();
            secretMap.put(secretName,keyMap);
            keyMap.put(key,DbUtil.decodeBase64(value));
        }else{
            secretMap.get(secretName).put(key,DbUtil.decodeBase64(value));
        }
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
