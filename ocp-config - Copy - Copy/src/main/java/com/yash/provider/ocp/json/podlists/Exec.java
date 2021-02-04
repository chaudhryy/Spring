
package com.yash.provider.ocp.json.podlists;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "command"
})
public class Exec {

    @JsonProperty("command")
    private List<String> command = null;

    @JsonProperty("command")
    public List<String> getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(List<String> command) {
        this.command = command;
    }

    public Exec withCommand(List<String> command) {
        this.command = command;
        return this;
    }

}
