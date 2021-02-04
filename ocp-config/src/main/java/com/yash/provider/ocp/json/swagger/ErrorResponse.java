
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "properties"
})
public class ErrorResponse {

    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private Properties____ properties;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public ErrorResponse withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("properties")
    public Properties____ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties____ properties) {
        this.properties = properties;
    }

    public ErrorResponse withProperties(Properties____ properties) {
        this.properties = properties;
        return this;
    }

}
