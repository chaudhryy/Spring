
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phase",
    "conditions",
    "hostIP",
    "podIP",
    "startTime",
    "containerStatuses",
    "qosClass"
})
public class Status {

    @JsonProperty("phase")
    private String phase;
    @JsonProperty("conditions")
    private List<Condition> conditions = null;
    @JsonProperty("hostIP")
    private String hostIP;
    @JsonProperty("podIP")
    private String podIP;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("containerStatuses")
    private List<ContainerStatus> containerStatuses = null;
    @JsonProperty("qosClass")
    private String qosClass;

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Status withPhase(String phase) {
        this.phase = phase;
        return this;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Status withConditions(List<Condition> conditions) {
        this.conditions = conditions;
        return this;
    }

    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    public Status withHostIP(String hostIP) {
        this.hostIP = hostIP;
        return this;
    }

    @JsonProperty("podIP")
    public String getPodIP() {
        return podIP;
    }

    @JsonProperty("podIP")
    public void setPodIP(String podIP) {
        this.podIP = podIP;
    }

    public Status withPodIP(String podIP) {
        this.podIP = podIP;
        return this;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Status withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsonProperty("containerStatuses")
    public List<ContainerStatus> getContainerStatuses() {
        return containerStatuses;
    }

    @JsonProperty("containerStatuses")
    public void setContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
    }

    public Status withContainerStatuses(List<ContainerStatus> containerStatuses) {
        this.containerStatuses = containerStatuses;
        return this;
    }

    @JsonProperty("qosClass")
    public String getQosClass() {
        return qosClass;
    }

    @JsonProperty("qosClass")
    public void setQosClass(String qosClass) {
        this.qosClass = qosClass;
    }

    public Status withQosClass(String qosClass) {
        this.qosClass = qosClass;
        return this;
    }

}
