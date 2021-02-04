
package com.yash.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "env",
    "resource"
})
public class AppEnvJson {

    @JsonProperty("env")
    private List<Env> env = null;
    @JsonProperty("resource")
    private List<Resource> resource = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("env")
    public List<Env> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<Env> env) {
        this.env = env;
    }

    public AppEnvJson withEnv(List<Env> env) {
        this.env = env;
        return this;
    }

    @JsonProperty("resource")
    public List<Resource> getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(List<Resource> resource) {
        this.resource = resource;
    }

    public AppEnvJson withResource(List<Resource> resource) {
        this.resource = resource;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AppEnvJson withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AppEnvJson.class.getSimpleName() + "[", "]")
                .add("env=" + env)
                .add("resource=" + resource)
                .add("additionalProperties=" + additionalProperties)
                .toString();
    }
}
