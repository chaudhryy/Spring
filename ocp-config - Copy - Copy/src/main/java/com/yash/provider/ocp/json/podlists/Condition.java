
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "status",
    "lastProbeTime",
    "lastTransitionTime"
})
public class Condition {

    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("lastProbeTime")
    private Object lastProbeTime;
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Condition withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Condition withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("lastProbeTime")
    public Object getLastProbeTime() {
        return lastProbeTime;
    }

    @JsonProperty("lastProbeTime")
    public void setLastProbeTime(Object lastProbeTime) {
        this.lastProbeTime = lastProbeTime;
    }

    public Condition withLastProbeTime(Object lastProbeTime) {
        this.lastProbeTime = lastProbeTime;
        return this;
    }

    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    public Condition withLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
        return this;
    }

}
