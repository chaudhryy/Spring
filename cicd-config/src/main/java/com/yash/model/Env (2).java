//
//package com.yash.model;
//
//import java.util.HashMap;
//import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "name",
//    "valueFrom",
//    "value",
//    "secretKey",
//    "secretName"
//})
//public class Env {
//
//    @JsonProperty("name")
//    private String name;
//    @JsonProperty("valueFrom")
//    private String valueFrom;
//    @JsonProperty("value")
//    private String value;
//    @JsonProperty("secretKey")
//    private String secretKey;
//    @JsonProperty("secretName")
//    private String secretName;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Env withName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    @JsonProperty("valueFrom")
//    public String getValueFrom() {
//        return valueFrom;
//    }
//
//    @JsonProperty("valueFrom")
//    public void setValueFrom(String valueFrom) {
//        this.valueFrom = valueFrom;
//    }
//
//    public Env withValueFrom(String valueFrom) {
//        this.valueFrom = valueFrom;
//        return this;
//    }
//
//    @JsonProperty("value")
//    public String getValue() {
//        return value;
//    }
//
//    @JsonProperty("value")
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public Env withValue(String value) {
//        this.value = value;
//        return this;
//    }
//
//    @JsonProperty("secretKey")
//    public String getSecretKey() {
//        return secretKey;
//    }
//
//    @JsonProperty("secretKey")
//    public void setSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//    }
//
//    public Env withSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//        return this;
//    }
//
//    @JsonProperty("secretName")
//    public String getSecretName() {
//        return secretName;
//    }
//
//    @JsonProperty("secretName")
//    public void setSecretName(String secretName) {
//        this.secretName = secretName;
//    }
//
//    public Env withSecretName(String secretName) {
//        this.secretName = secretName;
//        return this;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//    public Env withAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//        return this;
//    }
//
//}
