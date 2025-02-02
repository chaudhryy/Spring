package nz.co.spark.openshift.utility.fuse.cache;

import nz.co.spark.openshift.utility.fuse.model.EnvTypeEnum;
import nz.co.spark.openshift.utility.fuse.model.ResponseOCPAuthToken;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class LocalCache {

    private Map<EnvTypeEnum, ResponseOCPAuthToken> authorizationMap = new LinkedHashMap<>();

    private String namespace;

    private int lastVersion;

    @Value("${ocp.username}")
    private String username;

    @Value("${ocp.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
            keyMap.put(key,decodeBase64(value));
        }else{
            secretMap.get(secretName).put(key,decodeBase64(value));
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

    public String getAuthorization(EnvTypeEnum type) {
        ResponseOCPAuthToken token=authorizationMap.get(type);
        if(token!= null  ){ //&& token.getExpiresIn().before(Calendar.getInstance())){
            return token.getAccessToken();
        }
        return "" ;
    }

    public void setAuthorization(ResponseOCPAuthToken authorization,EnvTypeEnum type) {
        this.authorizationMap.put(type,authorization);
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace,EnvTypeEnum type) {
        this.namespace = namespace;
    }

    private  String decodeBase64(String encodedString) {
        byte[] byteArray = Base64.decodeBase64(encodedString.getBytes());


       return new String(byteArray);
    }
}
