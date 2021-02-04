
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capabilities",
    "runAsUser"
})
public class SecurityContext {

    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonProperty("runAsUser")
    private Long runAsUser;

    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public SecurityContext withCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }

    @JsonProperty("runAsUser")
    public Long getRunAsUser() {
        return runAsUser;
    }

    @JsonProperty("runAsUser")
    public void setRunAsUser(Long runAsUser) {
        this.runAsUser = runAsUser;
    }

    public SecurityContext withRunAsUser(Long runAsUser) {
        this.runAsUser = runAsUser;
        return this;
    }

}
