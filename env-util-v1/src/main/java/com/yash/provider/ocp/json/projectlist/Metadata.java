
package com.yash.provider.ocp.json.projectlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "selfLink",
    "uid",
    "resourceVersion",
    "creationTimestamp",
    "annotations"
})
public class Metadata {

    @JsonProperty("name")
    private String name;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("creationTimestamp")
    private String creationTimestamp;
    @JsonProperty("annotations")
    private Annotations annotations;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Metadata withName(String name) {
        this.name = name;
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

    public Metadata withSelfLink(String selfLink) {
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

    public Metadata withUid(String uid) {
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

    public Metadata withResourceVersion(String resourceVersion) {
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

    public Metadata withCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
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

    public Metadata withAnnotations(Annotations annotations) {
        this.annotations = annotations;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Metadata.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("selfLink='" + selfLink + "'")
                .add("uid='" + uid + "'")
                .add("resourceVersion='" + resourceVersion + "'")
                .add("creationTimestamp='" + creationTimestamp + "'")
                .add("annotations=" + annotations)
                .toString();
    }
}
