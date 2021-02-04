
package com.yash.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creationTimestamp",
    "labels",
    "annotations"
})
public class Metadata__ {

    @JsonProperty("creationTimestamp")
    private Object creationTimestamp;
    @JsonProperty("labels")
    private Labels_ labels;
    @JsonProperty("annotations")
    private Annotations_ annotations;

    @JsonProperty("creationTimestamp")
    public Object getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(Object creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Metadata__ withCreationTimestamp(Object creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
        return this;
    }

    @JsonProperty("labels")
    public Labels_ getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels_ labels) {
        this.labels = labels;
    }

    public Metadata__ withLabels(Labels_ labels) {
        this.labels = labels;
        return this;
    }

    @JsonProperty("annotations")
    public Annotations_ getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Annotations_ annotations) {
        this.annotations = annotations;
    }

    public Metadata__ withAnnotations(Annotations_ annotations) {
        this.annotations = annotations;
        return this;
    }

}
