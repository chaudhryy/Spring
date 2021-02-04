
package com.yash.provider.ocp.json.podlists;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "generateName",
    "namespace",
    "selfLink",
    "uid",
    "resourceVersion",
    "creationTimestamp",
    "labels",
    "annotations",
    "ownerReferences"
})
public class Metadata_ {

    @JsonProperty("name")
    private String name;
    @JsonProperty("generateName")
    private String generateName;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("creationTimestamp")
    private String creationTimestamp;
    @JsonProperty("labels")
    private Labels labels;
    @JsonProperty("annotations")
    private Annotations annotations;
    @JsonProperty("ownerReferences")
    private List<OwnerReference> ownerReferences = null;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Metadata_ withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("generateName")
    public String getGenerateName() {
        return generateName;
    }

    @JsonProperty("generateName")
    public void setGenerateName(String generateName) {
        this.generateName = generateName;
    }

    public Metadata_ withGenerateName(String generateName) {
        this.generateName = generateName;
        return this;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Metadata_ withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public Metadata_ withSelfLink(String selfLink) {
        this.selfLink = selfLink;
        return this;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    public Metadata_ withUid(String uid) {
        this.uid = uid;
        return this;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public Metadata_ withResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
        return this;
    }

    @JsonProperty("creationTimestamp")
    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Metadata_ withCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
        return this;
    }

    @JsonProperty("labels")
    public Labels getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public Metadata_ withLabels(Labels labels) {
        this.labels = labels;
        return this;
    }

    @JsonProperty("annotations")
    public Annotations getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Metadata_ withAnnotations(Annotations annotations) {
        this.annotations = annotations;
        return this;
    }

    @JsonProperty("ownerReferences")
    public List<OwnerReference> getOwnerReferences() {
        return ownerReferences;
    }

    @JsonProperty("ownerReferences")
    public void setOwnerReferences(List<OwnerReference> ownerReferences) {
        this.ownerReferences = ownerReferences;
    }

    public Metadata_ withOwnerReferences(List<OwnerReference> ownerReferences) {
        this.ownerReferences = ownerReferences;
        return this;
    }

}
