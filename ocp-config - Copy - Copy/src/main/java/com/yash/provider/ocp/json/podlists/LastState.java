
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "terminated"
})
public class LastState {

    @JsonProperty("terminated")
    private Terminated terminated;

    @JsonProperty("terminated")
    public Terminated getTerminated() {
        return terminated;
    }

    @JsonProperty("terminated")
    public void setTerminated(Terminated terminated) {
        this.terminated = terminated;
    }

    public LastState withTerminated(Terminated terminated) {
        this.terminated = terminated;
        return this;
    }

}
