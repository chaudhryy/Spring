
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latestVersion",
    "observedGeneration",
    "replicas",
    "updatedReplicas",
    "availableReplicas",
    "unavailableReplicas",
    "details",
    "conditions",
    "readyReplicas"
})
public class Status {

    @JsonProperty("latestVersion")
    private Long latestVersion;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("replicas")
    private Long replicas;
    @JsonProperty("updatedReplicas")
    private Long updatedReplicas;
    @JsonProperty("availableReplicas")
    private Long availableReplicas;
    @JsonProperty("unavailableReplicas")
    private Long unavailableReplicas;
    @JsonProperty("details")
    private Details details;
    @JsonProperty("conditions")
    private List<Condition> conditions = null;
    @JsonProperty("readyReplicas")
    private Long readyReplicas;

    @JsonProperty("latestVersion")
    public Long getLatestVersion() {
        return latestVersion;
    }

    @JsonProperty("latestVersion")
    public void setLatestVersion(Long latestVersion) {
        this.latestVersion = latestVersion;
    }

    public Status withLatestVersion(Long latestVersion) {
        this.latestVersion = latestVersion;
        return this;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    public Status withObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
        return this;
    }

    @JsonProperty("replicas")
    public Long getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Long replicas) {
        this.replicas = replicas;
    }

    public Status withReplicas(Long replicas) {
        this.replicas = replicas;
        return this;
    }

    @JsonProperty("updatedReplicas")
    public Long getUpdatedReplicas() {
        return updatedReplicas;
    }

    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Long updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    public Status withUpdatedReplicas(Long updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
        return this;
    }

    @JsonProperty("availableReplicas")
    public Long getAvailableReplicas() {
        return availableReplicas;
    }

    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Long availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    public Status withAvailableReplicas(Long availableReplicas) {
        this.availableReplicas = availableReplicas;
        return this;
    }

    @JsonProperty("unavailableReplicas")
    public Long getUnavailableReplicas() {
        return unavailableReplicas;
    }

    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Long unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    public Status withUnavailableReplicas(Long unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
        return this;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    public Status withDetails(Details details) {
        this.details = details;
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

    @JsonProperty("readyReplicas")
    public Long getReadyReplicas() {
        return readyReplicas;
    }

    @JsonProperty("readyReplicas")
    public void setReadyReplicas(Long readyReplicas) {
        this.readyReplicas = readyReplicas;
    }

    public Status withReadyReplicas(Long readyReplicas) {
        this.readyReplicas = readyReplicas;
        return this;
    }

}
