
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "properties"
})
public class TrustorEntityListing {

    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private Properties_______ properties;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public TrustorEntityListing withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("properties")
    public Properties_______ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties_______ properties) {
        this.properties = properties;
    }

    public TrustorEntityListing withProperties(Properties_______ properties) {
        this.properties = properties;
        return this;
    }

}
