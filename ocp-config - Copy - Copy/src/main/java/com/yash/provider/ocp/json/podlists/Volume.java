
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "persistentVolumeClaim",
    "secret",
    "configMap"
})
public class Volume {

    @JsonProperty("name")
    private String name;
    @JsonProperty("persistentVolumeClaim")
    private PersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("secret")
    private Secret secret;
    @JsonProperty("configMap")
    private ConfigMap configMap;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Volume withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("persistentVolumeClaim")
    public PersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    public Volume withPersistentVolumeClaim(PersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
        return this;
    }

    @JsonProperty("secret")
    public Secret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public Volume withSecret(Secret secret) {
        this.secret = secret;
        return this;
    }

    @JsonProperty("configMap")
    public ConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ConfigMap configMap) {
        this.configMap = configMap;
    }

    public Volume withConfigMap(ConfigMap configMap) {
        this.configMap = configMap;
        return this;
    }

}
