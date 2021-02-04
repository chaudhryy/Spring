package com.yash.model.consumer;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clienId",
        "fullName",
        "oAuth",
        "type"
})
public class Oauth2Response {

    @JsonProperty("clienId")
    private String clienId;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("oAuth")
    private OAuth oAuth;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("clienId")
    public String getClienId() {
        return clienId;
    }

    @JsonProperty("clienId")
    public void setClienId(String clienId) {
        this.clienId = clienId;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("oAuth")
    public OAuth getOAuth() {
        return oAuth;
    }

    @JsonProperty("oAuth")
    public void setOAuth(OAuth oAuth) {
        this.oAuth = oAuth;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}