
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "running"
})
public class State {

    @JsonProperty("running")
    private Running running;

    @JsonProperty("running")
    public Running getRunning() {
        return running;
    }

    @JsonProperty("running")
    public void setRunning(Running running) {
        this.running = running;
    }

    public State withRunning(Running running) {
        this.running = running;
        return this;
    }

}
