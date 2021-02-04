
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "properties"
})
public class Trustor {

    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private Properties_____ properties;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Trustor withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("properties")
    public Properties_____ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties_____ properties) {
        this.properties = properties;
    }

    public Trustor withProperties(Properties_____ properties) {
        this.properties = properties;
        return this;
    }

}
