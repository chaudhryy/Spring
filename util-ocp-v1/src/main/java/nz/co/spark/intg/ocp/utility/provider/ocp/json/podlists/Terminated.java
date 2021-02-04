
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exitCode",
    "reason",
    "startedAt",
    "finishedAt",
    "containerID"
})
public class Terminated {

    @JsonProperty("exitCode")
    private Long exitCode;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("startedAt")
    private String startedAt;
    @JsonProperty("finishedAt")
    private String finishedAt;
    @JsonProperty("containerID")
    private String containerID;

    @JsonProperty("exitCode")
    public Long getExitCode() {
        return exitCode;
    }

    @JsonProperty("exitCode")
    public void setExitCode(Long exitCode) {
        this.exitCode = exitCode;
    }

    public Terminated withExitCode(Long exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Terminated withReason(String reason) {
        this.reason = reason;
        return this;
    }

    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public Terminated withStartedAt(String startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    @JsonProperty("finishedAt")
    public String getFinishedAt() {
        return finishedAt;
    }

    @JsonProperty("finishedAt")
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Terminated withFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    @JsonProperty("containerID")
    public String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public Terminated withContainerID(String containerID) {
        this.containerID = containerID;
        return this;
    }

}
