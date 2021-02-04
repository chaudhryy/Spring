
package com.yash.model.consumer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "swaggerId",
    "name",
    "hostname",
    "tags"
})
public class Definition {

    @JsonProperty("swaggerId")
    private String swaggerId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("tags")
    private List<String> tags = null;

    @JsonProperty("swaggerId")
    public String getSwaggerId() {
        return swaggerId;
    }

    @JsonProperty("swaggerId")
    public void setSwaggerId(String swaggerId) {
        this.swaggerId = swaggerId;
    }

    public Definition withSwaggerId(String swaggerId) {
        this.swaggerId = swaggerId;
        return this;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Definition withHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Definition withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Definition withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
