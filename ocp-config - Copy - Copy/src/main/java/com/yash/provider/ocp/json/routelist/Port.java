
package com.yash.provider.ocp.json.routelist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "targetPort"
})
public class Port {

    @JsonProperty("targetPort")
    private String targetPort;

    @JsonProperty("targetPort")
    public String getTargetPort() {
        return targetPort;
    }

    @JsonProperty("targetPort")
    public void setTargetPort(String targetPort) {
        this.targetPort = targetPort;
    }

    public Port withTargetPort(String targetPort) {
        this.targetPort = targetPort;
        return this;
    }

}
