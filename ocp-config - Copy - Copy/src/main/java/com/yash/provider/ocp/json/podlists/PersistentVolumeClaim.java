
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claimName"
})
public class PersistentVolumeClaim {

    @JsonProperty("claimName")
    private String claimName;

    @JsonProperty("claimName")
    public String getClaimName() {
        return claimName;
    }

    @JsonProperty("claimName")
    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    public PersistentVolumeClaim withClaimName(String claimName) {
        this.claimName = claimName;
        return this;
    }

}
