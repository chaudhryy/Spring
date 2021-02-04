
package com.yash.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "defaultMode"
})
public class ConfigMap {

    @JsonProperty("name")
    private String name;
    @JsonProperty("defaultMode")
    private Long defaultMode;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ConfigMap withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("defaultMode")
    public Long getDefaultMode() {
        return defaultMode;
    }

    @JsonProperty("defaultMode")
    public void setDefaultMode(Long defaultMode) {
        this.defaultMode = defaultMode;
    }

    public ConfigMap withDefaultMode(Long defaultMode) {
        this.defaultMode = defaultMode;
        return this;
    }

}
