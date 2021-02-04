
package com.yash.provider.ocp.json.CMlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "selfLink",
    "resourceVersion"
})
public class Metadata {

    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("resourceVersion")
    private String resourceVersion;

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

}
